package co.edu.uniandes.isis2503.nosqljpa.service;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IClienteLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IContrasenaLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IInmuebleLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ClienteLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ClienteConverter.CONVERTER;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ContrasenaConverter.CONVERTERC;
import co.edu.uniandes.isis2503.nosqljpa.logic.ContrasenaLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.InmuebleLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ClienteDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
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
@Path("/cliente")
@Consumes
@Produces(MediaType.APPLICATION_JSON)
public class ClienteService {
    
    private final IClienteLogic clienteLogic;
    private final IContrasenaLogic contrasenaLogic;
    private final IInmuebleLogic inmuebleLogic;

    public ClienteService() {
        this.clienteLogic = new ClienteLogic();
        this.contrasenaLogic = new ContrasenaLogic();
        this.inmuebleLogic = new InmuebleLogic();
    }

    @POST
    public ClienteDTO add(ClienteDTO dto) {
        return clienteLogic.add(dto);
    }

    @POST
    @Path("/{id}/inmueble/{inmueble}/contrasena")
    public ContrasenaDTO add(@PathParam("id") String id, @PathParam("inmueble") String inmueble,ContrasenaDTO dto) {
        dto.setClienteC(CONVERTER.dtoToEntity(clienteLogic.find(id)));
        dto.setInmuebleC(CONVERTERI.dtoToEntity(inmuebleLogic.find(id)));
        clienteLogic.find(id).setContrasena(CONVERTERC.dtoToEntity(dto));
        inmuebleLogic.find(id).setContrasena(CONVERTERC.dtoToEntity(dto));
        return contrasenaLogic.add(dto);
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
    @Path("/inmueble/{inmueble}")
    public ContrasenaDTO allContrasena(@PathParam("inmueble") String inmueble){
       // return clienteLogic.all(inmueble);
       return null;
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
            Logger.getLogger(ClienteService.class).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
}
