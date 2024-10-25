package au.com.infomedix.charting.sago.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallingCriteria {

  private String title;
  private String type;
  private Map<String, CriteriaDefinition> ranges;
}
