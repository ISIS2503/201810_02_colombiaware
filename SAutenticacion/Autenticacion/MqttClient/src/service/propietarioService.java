/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import auth0.AuthorizationFilter;
import auth0.Secured;
import dto.model.propietarioDTO;
import interfaces.IPropietarioLogic;
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
import logic.propietarioLogic;

/**
 *
 * @author cs.gomez
 */
@Path("/propietario")
@Secured({AuthorizationFilter.Role.propietario})
@Produces(MediaType.APPLICATION_JSON)
public class propietarioService {

    private final IPropietarioLogic propietarioLogic;

    public propietarioService() {
        this.propietarioLogic = new propietarioLogic();
    }

    @POST
    public propietarioDTO add(propietarioDTO dto) {
        return propietarioLogic.add(dto);
    }
    
    @PUT
    public propietarioDTO update(propietarioDTO dto) {
        return propietarioLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public propietarioDTO find(@PathParam("id") String id) {
        return propietarioLogic.find(id);
    }

    @GET
    public List<propietarioDTO> all() {
        return propietarioLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            propietarioLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: propietario was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(propietarioService.class.getName()).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
    
 
    }
