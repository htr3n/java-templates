package au.com.infomedix.charting.sago.adapter.persistence;

import au.com.infomedix.charting.sago.adapter.persistence.entity.CallingCriteriaEntity;
import au.com.infomedix.charting.sago.port.spi.ChartRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.jpa.QueryHints;

@Stateless
public class ChartRepositoryImpl implements ChartRepository {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<CallingCriteriaEntity> getCallingCriteria() {
    final TypedQuery<CallingCriteriaEntity> query =
        entityManager.createNamedQuery(
            "CallingCriteriaEntity.findAll", CallingCriteriaEntity.class);
    query.setHint(QueryHints.HINT_READONLY, true);
    return query.getResultList();
  }
}
