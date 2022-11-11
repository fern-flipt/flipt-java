package com.flipt.api.client.segments;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.segments.exceptions.CreateException;
import com.flipt.api.client.segments.exceptions.DeleteException;
import com.flipt.api.client.segments.exceptions.GetException;
import com.flipt.api.client.segments.exceptions.ListException;
import com.flipt.api.client.segments.exceptions.UpdateException;
import com.flipt.api.client.segments.types.FliptCreateSegmentRequest;
import com.flipt.api.client.segments.types.FliptSegment;
import com.flipt.api.client.segments.types.FliptSegmentList;
import com.flipt.api.client.segments.types.FliptUpdateSegmentRequest;
import com.flipt.api.core.BasicAuth;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.Integer;
import java.lang.String;
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
@Path("/segments")
interface SegmentsService {
  @GET
  @Path("/")
  FliptSegmentList list(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset,
      @QueryParam("pageToken") String pageToken) throws ListException;

  @POST
  @Path("/")
  FliptSegment create(@HeaderParam("Authorization") BasicAuth auth, FliptCreateSegmentRequest body)
      throws CreateException;

  @GET
  @Path("/{key}")
  FliptSegment get(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key)
      throws GetException;

  @DELETE
  @Path("/{key}")
  void delete(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key) throws
      DeleteException;

  @PUT
  @Path("/{key}")
  FliptSegment update(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key,
      FliptUpdateSegmentRequest body) throws UpdateException;

  static SegmentsService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new SegmentsServiceErrorDecoder()).target(SegmentsService.class, url);
  }
}
