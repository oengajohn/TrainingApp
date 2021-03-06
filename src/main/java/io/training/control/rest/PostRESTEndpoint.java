package io.training.control.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.training.control.rest.impl.Error;
import io.training.entity.Post;


@Path("/posts")
@Tag(name = "Post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PostRESTEndpoint {
  @GET
  @Path("/{id}")
  @Operation(
          summary = "Get post by  id",
          responses = {
                  @ApiResponse(
                          description = "The Post",
                          content =
                          @Content(
                                  mediaType = "application/json",
                                  schema = @Schema(implementation = Post.class))),
                  @ApiResponse(responseCode = "400", description = "Post not found", content =
                  @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation = Error.class)))
          })
  Response retrievePost(@PathParam("id") int id);

  @POST
    Response createPost(Post post);
}
