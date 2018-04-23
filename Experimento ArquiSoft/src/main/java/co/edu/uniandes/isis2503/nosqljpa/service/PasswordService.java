package co.edu.uniandes.isis2503.nosqljpa.service;


import co.edu.uniandes.isis2503.nosqljpa.interfaces.IContrasenaLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ContrasenaLogic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 *
 * @author USUARIO
 */
@Path("/claves")
@Produces("text/plain")
public class PasswordService {

    ContrasenaLogic contrasenaLogic;
    
    public PasswordService() {
        contrasenaLogic = new ContrasenaLogic();
    }
    
    @GET
    @Path("/claves/{horario}")
    public String contrasena(@PathParam("horario") String horario){
        return contrasenaLogic.contraseniasWiring(horario);
    }  
}
