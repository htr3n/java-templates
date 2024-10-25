package au.com.infomedix.charting.sago.adapter.rest;

import au.com.infomedix.charting.sago.adapter.config.CachingConfigurationService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Stateless
@Path("/configurations")
public class ConfigurationResource {

  @Inject CachingConfigurationService configurationService;

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Response getAll() {
    try {
      return Response.ok().entity(configurationService.getAll()).build();
    } catch (Exception e) {
      String errorMsg = "Error when getting all configurations due to '" + e.getMessage() + "'";
      log.error(errorMsg, e);
      return Response.serverError().entity(errorMsg).build();
    }
  }

  @GET
  @Path("/{key}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response get(@PathParam("key") final String key) {
    try {
      final String value = configurationService.get(key);
      return Response.ok().entity(value).build();
    } catch (Exception e) {
      String errorMsg =
          "Error when getting configuration for key '" + key + "' due to '" + e.getMessage() + "'";
      log.error(errorMsg, e);
      return Response.serverError().entity(errorMsg).build();
    }
  }

  @PUT
  @Path("/{key}")
  @Consumes({MediaType.APPLICATION_JSON})
  public Response update(@PathParam("key") final String key, String value) {
    try {
      int updated = configurationService.update(key, value);
      if (updated > 0) {
        return Response.status(Response.Status.NO_CONTENT).build();
      } else {
        String errorMsg = "Failed to update configuration pair '" + key + "' => '" + value + "'";
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMsg).build();
      }
    } catch (Exception e) {
      String errorMsg = "Error when refreshing configuration due to '" + e.getMessage() + "'";
      log.error(errorMsg, e);
      return Response.serverError().entity(errorMsg).build();
    }
  }
}
