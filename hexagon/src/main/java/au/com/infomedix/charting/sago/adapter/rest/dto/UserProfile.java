package au.com.infomedix.charting.sago.adapter.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {
  private String firstname;
  private String lastname;
  private String designation;
  private List<String> roles;
  private String userId;
}
