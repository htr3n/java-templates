package au.com.infomedix.charting.sago.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sago__criteria_colour")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaColour implements Serializable {

  private static final long serialVersionUID = -563056027544663891L;

  @Id
  @Column(length = 16)
  private String id;

  @Column(length = 20)
  private String rgb;

  @OneToMany(mappedBy = "colour", fetch = FetchType.LAZY)
  private List<CriteriaDefinitionEntity> criteriaDefinitions;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CriteriaColour that = (CriteriaColour) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
