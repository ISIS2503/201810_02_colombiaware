/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import auth0.AuthorizationFilter;
import auth0.Secured;
import dto.model.yaleDTO;
import interfaces.IYaleLogic;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.yaleLogic;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cs.gomez
 */
@Path("/yale")
@Secured({Role.yale})
@Produces(MediaType.APPLICATION_JSON)
public class yaleService {

    private final IYaleLogic yaleLogic;

    public yaleService() {
        this.yaleLogic = new yaleLogic();
    }

    @POST
    public yaleDTO add(yaleDTO dto) {
        return yaleLogic.add(dto);
    }

 
    }

    @PUT
    public yaleDTO update(yaleDTO dto) {
        return yaleLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public yaleDTO find(@PathParam("id") String id) {
        return yaleLogic.find(id);
    }
    @GET
    public List<yaleDTO> all() {
        return yaleLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            yaleLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: yale was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(yaleService.class.getName()).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
}
