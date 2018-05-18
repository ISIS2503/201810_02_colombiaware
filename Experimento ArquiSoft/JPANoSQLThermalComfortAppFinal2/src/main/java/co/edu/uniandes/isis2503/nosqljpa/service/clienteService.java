/*
 * The MIT License
 *
 * Copyright 2018 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IClienteLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IContrasenaLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IInmuebleLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ClienteLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ContrasenaLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.InmuebleLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ClienteConverter.CONVERTER;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ContrasenaConverter.CONVERTERC;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
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
public class clienteService {
    private final IClienteLogic clienteLogic;
    private final IContrasenaLogic contrasenaLogic;
    private final IInmuebleLogic inmuebleLogic;

    public clienteService() {
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
        dto.setInmuebleC(CONVERTERI.dtoToEntity(inmuebleLogic.find(id)));
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
    @Path("/contrasena/{contrasena}")
    public ContrasenaDTO allContrasena(@PathParam("id") String id,@PathParam("contrasena") String contrasena){
       return clienteLogic.allContrasena(contrasena);
    }
    
//    @GET
//    @Path("/{id}/contrasena/{contrasena}")
//    public List<ContrasenaDTO> allContrasenaMes(@PathParam("id") String id){
//       return CONVERTERC.listEntitiesToListDTOs(clienteLogic.find(id).getContrasenaC());
//    }
    
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
