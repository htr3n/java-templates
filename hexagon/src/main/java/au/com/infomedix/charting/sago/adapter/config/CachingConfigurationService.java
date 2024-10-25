package au.com.infomedix.charting.sago.adapter.config;

import au.com.infomedix.charting.sago.port.spi.ConfigurationService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.QueryHints;

@Slf4j
@Stateless
public class CachingConfigurationService implements ConfigurationService {

  protected static final String TABLE_NAME = "configuration";
  @PersistenceContext EntityManager entityManager;

  private String loadConfiguration(final String name) {
    if (StringUtils.isNotBlank(name)) {
      final String sql = "SELECT CONCAT(value, '') FROM " + TABLE_NAME + " WHERE name=:name";
      final Query query = this.entityManager.createNativeQuery(sql);
      query.setParameter("name", name).setHint(QueryHints.READ_ONLY, true).setMaxResults(1);
      try {
        final Object result = query.getSingleResult();
        if (result != null) {
          return result.toString();
        }
      } catch (NoResultException e) {
        return null;
      }
    }
    return null;
  }

  /**
   * This method will return all configuration name-value pairs (be careful with the size of the
   * configuration database) and will not go through the internal cache.
   *
   * @return a {@link Map} of configuration name-value pairs
   */
  @SuppressWarnings("rawtypes")
  public Map getAll() {
    final String sql = "SELECT c.name as name, c.value as value FROM " + TABLE_NAME + " c";
    final List<Object[]> list =
        this.entityManager
            .createNativeQuery(sql)
            .setHint(QueryHints.READ_ONLY, true)
            .getResultList();

    if (list != null && !list.isEmpty()) {
      return list.stream()
          .filter(Objects::nonNull)
          .collect(Collectors.toMap(row -> row[0], row -> row[1]));
    }
    return Collections.emptyMap();
  }

  @Override
  public String get(final String name) {
    if (StringUtils.isNotBlank(name)) {}
    return null;
  }

  @Override
  public int delete(final String name) {
    if (StringUtils.isNotBlank(name)) {
      log.info("Delete the configuration [name='{}']", name);

      final String sql = "DELETE FROM " + TABLE_NAME + " c WHERE c.name = :name";
      final Query query = this.entityManager.createNativeQuery(sql);
      query.setParameter("name", name);
      final int deletedCount = query.executeUpdate();
      return deletedCount;
    }
    return 0;
  }

  @Override
  public int deleteAll() {
    log.info("Delete all configurations");
    final int deletedCount =
        this.entityManager.createNativeQuery("DELETE FROM configuration").executeUpdate();
    return deletedCount;
  }

  @Override
  public void create(final String name, final String value) {
    if (StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
      log.warn(
          "The input configuration pair [{} => {}] is invalid, won't proceed to store into database",
          name,
          value);
      return;
    }

    log.info("Create a new configuration [name='{}', value='{}']", name, value);

    try {
      final String sql = "INSERT INTO " + TABLE_NAME + " (name, value) VALUES (:name, :value)";
      final Query query = this.entityManager.createNativeQuery(sql);
      query.setParameter("name", name);
      query.setParameter("value", value);
      query.executeUpdate();
    } catch (Exception e) {
      log.error("Error when creating a new configuration '{} => '{}'", name, value, e);
    }
  }

  @Override
  public int update(final String name, final String newValue) {
    if (StringUtils.isBlank(name) || StringUtils.isBlank(newValue)) {
      log.warn(
          "The input configuration pair [{} => {}] is invalid, won't proceed to update configuration",
          name,
          newValue);
      return -1;
    }

    log.info("Update the configuration name='{}'] with new value '{}'", name, newValue);

    final String sql = "UPDATE " + TABLE_NAME + " c SET c.value = :value WHERE c.name = :name";
    final Query query = this.entityManager.createNativeQuery(sql);
    query.setParameter("name", name);
    query.setParameter("value", newValue);
    return query.executeUpdate();
  }
}
