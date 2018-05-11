/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import auth0.AuthorizationFilter;
import auth0.Secured;
import dto.model.administradorDTO;
import interfaces.IAdministradorLogic;
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
import logic.administradorLogic;

/**
 *
 * @author cs.gomez
 */
@Path("/administrador")
@Secured({AuthorizationFilter.Role.administrador})
@Produces(MediaType.APPLICATION_JSON)
public class administradorService {

    private final IAdministradorLogic administradorLogic;

    public administradorService() {
        this.administradorLogic = new administradorLogic();
    }

    @POST
    public administradorDTO add(administradorDTO dto) {
        return administradorLogic.add(dto);
    }
    
    @PUT
    public administradorDTO update(administradorDTO dto) {
        return administradorLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public administradorDTO find(@PathParam("id") String id) {
        return administradorLogic.find(id);
    }

    @GET
    public List<administradorDTO> all() {
        return administradorLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            administradorLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: administrador was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(administradorService.class.getName()).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
    
 
    }
