package co.edu.uniandes.isis2503.nosqljpa.service;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IAdminLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IClienteLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IInmuebleLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IResidenciaLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.ISeguridadLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IYaleLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.AdminConverter.CONVERTERA;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ResidenciaConverter.CONVERTERR;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ClienteConverter.CONVERTER;
import co.edu.uniandes.isis2503.nosqljpa.logic.AdminLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ClienteLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.InmuebleLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ResidenciaLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.SeguridadLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.YaleLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AdminDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ClienteDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SeguridadDTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.sun.istack.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.core.Response;

/**
 *
 * @author ks.estupinan
 */
@Path("/yaleS")
@Consumes
@Produces(MediaType.APPLICATION_JSON)
public class YaleServices {
    
    private final IAdminLogic adminLogic;
    private final IClienteLogic clienteLogic;
    private final IInmuebleLogic inmuebleLogic;
    private final IResidenciaLogic residenciaLogic;
    private final ISeguridadLogic seguridadLogic;
    private final IYaleLogic yaleLogic;

    public YaleServices() {
        this.adminLogic = new AdminLogic();
        this.clienteLogic = new ClienteLogic();
        this.inmuebleLogic = new InmuebleLogic();
        this.residenciaLogic = new ResidenciaLogic();
        this.seguridadLogic = new SeguridadLogic();
        this.yaleLogic = new YaleLogic();
    }
    
    @POST
    @Path("/admin")
    public AdminDTO add(AdminDTO dto) {
        return adminLogic.add(dto);
    }
    
    @POST
    @Path("/admin/{id}/residencia")
    public ResidenciaDTO add(@PathParam("id") String id,ResidenciaDTO dto) {
        dto.setAdmin(CONVERTERA.dtoToEntity(adminLogic.find(id)));
        adminLogic.find(id).setResidencia(CONVERTERR.dtoToEntity(dto));
        return residenciaLogic.add(dto);
    }
    
    @POST
    @Path("/cliente")
    public ClienteDTO add(ClienteDTO dto) {
        return clienteLogic.add(dto);
    }
    
    @POST
    @Path("/cliente/{id}/inmueble")
    public InmuebleDTO add(@PathParam("id") String id,InmuebleDTO dto) {
        dto.setCliente(CONVERTER.dtoToEntity(clienteLogic.find(id)));
        clienteLogic.find(id).setInmueble(CONVERTERI.dtoToEntity(dto));
        return inmuebleLogic.add(dto);
    }
    
     @POST
    @Path("/residencia/{idR}/cliente/{idC}/inmueble")
    public InmuebleDTO addI(@PathParam("idR") String idR,@PathParam("idC") String idC,InmuebleDTO dto) {
        dto.setCliente(CONVERTER.dtoToEntity(clienteLogic.find(idC)));
        dto.setResidenciaI(CONVERTERR.dtoToEntity(residenciaLogic.find(idR)));
        clienteLogic.find(idC).setInmueble(CONVERTERI.dtoToEntity(dto));
        residenciaLogic.find(idR).setInmueble(CONVERTERI.dtoToEntity(dto));
        return inmuebleLogic.add(dto);
    }
    
    @POST
    @Path("/seguridad")
    public SeguridadDTO add(SeguridadDTO dto) {
        return seguridadLogic.add(dto);
    }
    
    @PUT
    public ClienteDTO update(ClienteDTO dto) {
        return clienteLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public ClienteDTO find(@PathParam("id") String id) {
        return clienteLogic.find(id);
    }
    
    @GET
    @Path("/inmueble/{inmueble}")
    public InmuebleDTO allInmueble(@PathParam("inmueble") String inmueble){
        return clienteLogic.allInmueble(inmueble);
    }

    @GET
    public List<ClienteDTO> all() {
        return clienteLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            clienteLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: Floor was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(clienteService.class).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
}
