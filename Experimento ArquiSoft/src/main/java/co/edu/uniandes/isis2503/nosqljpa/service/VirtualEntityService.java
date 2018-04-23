package co.edu.uniandes.isis2503.nosqljpa.service;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IAdminLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IClienteLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IInmuebleLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IResidenciaLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.ISeguridadLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IVirtualEntityLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IYaleLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.AdminLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ClienteLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.InmuebleLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ResidenciaLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.SeguridadLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.VirtualEntityLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.YaleLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.VirtualEntityDTO;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.AdminConverter.CONVERTERA;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ResidenciaConverter.CONVERTERR;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ClienteConverter.CONVERTER;
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
    private final IAdminLogic adminLogic;
    private final IClienteLogic clienteLogic;
    private final IInmuebleLogic inmuebleLogic;
    private final IResidenciaLogic residenciaLogic;
    private final ISeguridadLogic seguridadLogic;
    private final IYaleLogic yaleLogic;

    public VirtualEntityService() {
        this.virtualEntityLogic = new VirtualEntityLogic();
        this.adminLogic = new AdminLogic();
        this.clienteLogic = new ClienteLogic();
        this.inmuebleLogic = new InmuebleLogic();
        this.residenciaLogic = new ResidenciaLogic();
        this.seguridadLogic = new SeguridadLogic();
        this.yaleLogic = new YaleLogic();
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
    @Path("/admin/{id}/residencia/{residencia}")
    public List<VirtualEntityDTO> allResidencia(@PathParam("id") String id, @PathParam("residencia") String residencia){
        if(residenciaLogic.find(residencia).getAdmin() == CONVERTERA.dtoToEntity(adminLogic.find(id)))
            return virtualEntityLogic.allResidencia(residencia);
        else
            return null;
    }
    
    @GET
    @Path("/ciudad/{ciudad}")
    public List<VirtualEntityDTO> allCiudad(@PathParam("ciudad") String ciudad){
        return virtualEntityLogic.allCiudad(ciudad);
    }
    
    @GET
    @Path("/cliente/{id}/inmueble/{inmueble}")
    public List<VirtualEntityDTO> allInmueble(@PathParam("id") String id, @PathParam("inmueble") String inmueble){
        if(inmuebleLogic.find(inmueble).getCliente() == CONVERTER.dtoToEntity(clienteLogic.find(id)))
            return virtualEntityLogic.allInmueble(inmueble);
        else
            return null;
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
