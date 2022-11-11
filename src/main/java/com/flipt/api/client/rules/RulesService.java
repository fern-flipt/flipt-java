package com.flipt.api.client.rules;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.rules.exceptions.CreateException;
import com.flipt.api.client.rules.exceptions.DeleteException;
import com.flipt.api.client.rules.exceptions.GetException;
import com.flipt.api.client.rules.exceptions.ListException;
import com.flipt.api.client.rules.exceptions.OrderException;
import com.flipt.api.client.rules.exceptions.UpdateException;
import com.flipt.api.client.rules.types.FliptRule;
import com.flipt.api.client.rules.types.FliptRuleCreate;
import com.flipt.api.client.rules.types.FliptRuleList;
import com.flipt.api.client.rules.types.FliptRuleOrder;
import com.flipt.api.client.rules.types.FliptRuleUpdate;
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
@Path("/flags/{flagKey}/rules")
interface RulesService {
  @GET
  @Path("/")
  FliptRuleList list(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("limit") Optional<Integer> limit, @QueryParam("offset") Optional<Integer> offset,
      @QueryParam("pageToken") Optional<String> pageToken) throws ListException;

  @POST
  @Path("/")
  FliptRule create(@HeaderParam("Authorization") BasicAuth auth, FliptRuleCreate body) throws
      CreateException;

  @PUT
  @Path("/order")
  void order(@HeaderParam("Authorization") BasicAuth auth, FliptRuleOrder body) throws
      OrderException;

  @GET
  @Path("/{id}")
  FliptRule get(@HeaderParam("Authorization") BasicAuth auth, @PathParam("id") String id) throws
      GetException;

  @DELETE
  @Path("/{id}")
  void delete(@HeaderParam("Authorization") BasicAuth auth, @PathParam("id") String id) throws
      DeleteException;

  @PUT
  @Path("/{id}")
  void update(@HeaderParam("Authorization") BasicAuth auth, @PathParam("id") String id,
      FliptRuleUpdate body) throws UpdateException;

  static RulesService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new RulesServiceErrorDecoder()).target(RulesService.class, url);
  }
}
