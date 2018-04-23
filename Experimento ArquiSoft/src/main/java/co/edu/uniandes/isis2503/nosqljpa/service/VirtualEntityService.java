package co.edu.uniandes.isis2503.nosqljpa.service;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IVirtualEntityLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.VirtualEntityLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.VirtualEntityDTO;
import com.sun.istack.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
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
 * @author ks.estupinan
 */
@Path("/programaP")
@Consumes
@Produces(MediaType.APPLICATION_JSON)
public class VirtualEntityService {
    private final IVirtualEntityLogic virtualEntityLogic;

    public VirtualEntityService() {
        this.virtualEntityLogic = new VirtualEntityLogic();
    }

    @POST
    public VirtualEntityDTO add(VirtualEntityDTO dto) {
        return virtualEntityLogic.add(dto);
    }

    @PUT
    public VirtualEntityDTO update(VirtualEntityDTO dto) {
        return virtualEntityLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public VirtualEntityDTO find(@PathParam("id") String id) {
        return virtualEntityLogic.find(id);
    }
    
    @GET
    @Path("/residencia/{residencia}")
    public List<VirtualEntityDTO> allResidencia(@PathParam("residencia") String residencia){
        return virtualEntityLogic.allResidencia(residencia);
    }
    
    @GET
    @Path("/ciudad/{ciudad}")
    public List<VirtualEntityDTO> allCiudad(@PathParam("ciudad") String ciudad){
        return virtualEntityLogic.allCiudad(ciudad);
    }
    
    @GET
    @Path("/inmueble/{inmueble}")
    public List<VirtualEntityDTO> allInmueble(@PathParam("inmueble") String inmueble){
        return virtualEntityLogic.allInmueble(inmueble);
    }

    @GET
    public List<VirtualEntityDTO> all() {
        return virtualEntityLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            virtualEntityLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: Floor was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(VirtualEntityService.class).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
}
