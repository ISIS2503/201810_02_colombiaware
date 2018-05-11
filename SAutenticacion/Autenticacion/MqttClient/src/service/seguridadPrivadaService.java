/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import auth0.AuthorizationFilter;
import auth0.Secured;
import dto.model.seguridadPrivadaDTO;
import interfaces.ISeguridadPrivadaLogic;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logic.seguridadPrivadaLogic;

/**
 *
 * @author cs.gomez
 */
@Path("/seguridadPrivada")
@Secured({AuthorizationFilter.Role.seguridadPrivada})
@Produces(MediaType.APPLICATION_JSON)
public class seguridadPrivadaService {

    private final ISeguridadPrivadaLogic seguridadPrivadaLogic;

    public seguridadPrivadaService() {
        this.seguridadPrivadaLogic = new seguridadPrivadaLogic();
    }

    @POST
    public seguridadPrivadaDTO add(seguridadPrivadaDTO dto) {
        return seguridadPrivadaLogic.add(dto);
    }
    
    @PUT
    public seguridadPrivadaDTO update(seguridadPrivadaDTO dto) {
        return seguridadPrivadaLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public seguridadPrivadaDTO find(@PathParam("id") String id) {
        return seguridadPrivadaLogic.find(id);
    }

    @GET
    public List<seguridadPrivadaDTO> all() {
        return seguridadPrivadaLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            seguridadPrivadaLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: seguridadPrivada was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(seguridadPrivadaService.class.getName()).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
    
 
    }
