/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PlayerDTO;
import dto.SpinDTO;
import dto.WheelDTO;
import facades.WheelFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

/**
 *
 * @author Tweny
 */
@Path("wheel")
public class WheelResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final WheelFacade FACADE = WheelFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @Path("/msg")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllWheels() {
        return GSON.toJson(FACADE.getAllWheels());
    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getWheelById(@PathParam("id") int id) {
        return GSON.toJson(FACADE.getWheelById(id));
    }

    @Path("/companies")
    @RolesAllowed("admin")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCompanies() {
        return GSON.toJson(FACADE.getAllCompanies());
    }

    @Path("/spins")
    @RolesAllowed("admin")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllSpins() {
        return GSON.toJson(FACADE.getAllSpins());
    }

    @Path("/players")
    @RolesAllowed("admin")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllPlayers() {
        return GSON.toJson(FACADE.getAllPlayers());
    }

    @RolesAllowed("admin")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createWheel(String wheel) {
        WheelDTO wheelDTO = GSON.fromJson(wheel, WheelDTO.class);
        wheelDTO = FACADE.createWheel(wheelDTO);
        return GSON.toJson(wheelDTO);
    }

    @Path("{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createSpin(@PathParam("id") int id, String player) {
        PlayerDTO playerDTO = GSON.fromJson(player, PlayerDTO.class);
        SpinDTO spinDTO = FACADE.createSpin(playerDTO, id);
        return GSON.toJson(spinDTO);
    }

}
