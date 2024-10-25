package au.com.infomedix.charting.sago.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CriteriaDefinition {

  private Double min;
  private Double max;
  private Boolean alert;
  private String description;
  private String colour;
}
