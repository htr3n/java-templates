package au.com.infomedix.charting.sago.adapter.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "sago__criteria_definition",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "UK_sago__criteria_definition__name_criteria_id",
          columnNames = {"name", "criteria_id"})
    })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CriteriaDefinitionEntity implements Serializable {

  private static final long serialVersionUID = 6423670336274301215L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 2, nullable = false)
  private String name;

  @Column(columnDefinition = "decimal(6,2)")
  private Double min;

  @Column(columnDefinition = "decimal(6,2)")
  private Double max;

  @Column(length = 64)
  private String description;

  @Column(columnDefinition = "BIT", length = 1)
  private Boolean alert = Boolean.FALSE;

  @ManyToOne(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  @JoinColumn(
      name = "colour_id",
      nullable = false,
      foreignKey = @ForeignKey(name = "FK_sago__criteria_definition__colour"))
  private CriteriaColour colour;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "criteria_id",
      nullable = false,
      foreignKey = @ForeignKey(name = "FK_sago__criteria_definition__criteria"))
  private CallingCriteriaEntity callingCriteria;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CriteriaDefinitionEntity that = (CriteriaDefinitionEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
