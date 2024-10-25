package io.github.htr3n.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreationRequest {
  private String firstName;
  private String lastName;
  private String email;
}
