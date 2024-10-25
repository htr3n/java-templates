package io.github.htr3n.endpoint;

import io.github.htr3n.dto.UserCreationRequest;
import io.github.htr3n.dto.UserDto;
import io.github.htr3n.dto.UserUpdateRequest;
import io.github.htr3n.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {

  private final UserService userService;

  @Inject
  public UserResource(UserService userService) {
    this.userService = userService;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUser(@PathParam("id") String id) {
    UserDto user = userService.getUser(id);
    return Response.ok().entity(user).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createUser(UserCreationRequest request) {
    userService.createUser(request);
    return Response.ok().build();
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateUser(UserUpdateRequest request) {
    userService.updateUser(request);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteUser(@PathParam("id") String id) {
    userService.deleteUser(id);
    return Response.ok().build();
  }
}
