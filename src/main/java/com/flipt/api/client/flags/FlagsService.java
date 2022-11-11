package com.flipt.api.client.flags;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.flags.exceptions.CreateException;
import com.flipt.api.client.flags.exceptions.DeleteException;
import com.flipt.api.client.flags.exceptions.GetException;
import com.flipt.api.client.flags.exceptions.ListException;
import com.flipt.api.client.flags.exceptions.UpdateException;
import com.flipt.api.client.flags.types.FliptCreateFlagRequest;
import com.flipt.api.client.flags.types.FliptFlag;
import com.flipt.api.client.flags.types.FliptFlagList;
import com.flipt.api.client.flags.types.FliptFlagUpdate;
import com.flipt.api.core.BasicAuth;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/flags")
interface FlagsService {
  @GET
  @Path("/")
  FliptFlagList list(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("limit") Optional<Integer> limit, @QueryParam("offset") Optional<Integer> offset,
      @QueryParam("pageToken") Optional<String> pageToken) throws ListException;

  @POST
  @Path("/")
  FliptFlag create(@HeaderParam("Authorization") BasicAuth auth, FliptCreateFlagRequest body) throws
      CreateException;

  @GET
  @Path("/{key}")
  FliptFlag get(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key) throws
      GetException;

  @DELETE
  @Path("/{key}")
  void delete(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key) throws
      DeleteException;

  @PUT
  @Path("/{key}")
  FliptFlag update(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key,
      FliptFlagUpdate body) throws UpdateException;

  static FlagsService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new FlagsServiceErrorDecoder()).target(FlagsService.class, url);
  }
}
