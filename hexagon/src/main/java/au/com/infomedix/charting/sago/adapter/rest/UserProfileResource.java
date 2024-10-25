package au.com.infomedix.charting.sago.adapter.rest;

import au.com.infomedix.charting.sago.port.api.UserProfileService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
@Path("/user/profile")
public class UserProfileResource {
  private UserProfileService userProfileService;

  @Inject
  public void setUserProfileService(UserProfileService userProfileService) {
    this.userProfileService = userProfileService;
  }

  @GET
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public Response getUserProfile() {
    log.info("Received a request to get current user profile");
    try {
      return Response.ok().entity(userProfileService.getUserProfile()).build();
    } catch (Exception e) {
      log.error("Error when retrieving current user profile", e);
      final String message = "Error when retrieving current user profile: " + e.getMessage();
      return Response.serverError().type(MediaType.TEXT_PLAIN_TYPE).entity(message).build();
    }
  }
}
