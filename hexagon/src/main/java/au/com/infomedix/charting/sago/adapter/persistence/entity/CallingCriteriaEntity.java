package au.com.infomedix.charting.sago.adapter.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "sago__calling_criteria")
@NamedQueries({
  @NamedQuery(
      name = "CallingCriteriaEntity.findAll",
      query = "SELECT e FROM CallingCriteriaEntity e"),
})
public class CallingCriteriaEntity implements Serializable {

  private static final long serialVersionUID = -6380582769392457206L;

  @Id
  @Column(length = 64)
  private String id;

  @Column(length = 64)
  private String title;

  @Column(length = 32)
  private String type;

  @OneToMany(
      cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
      fetch = FetchType.LAZY,
      mappedBy = "callingCriteria",
      orphanRemoval = true)
  private List<CriteriaDefinitionEntity> ranges;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallingCriteriaEntity that = (CallingCriteriaEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
