package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.ClienteEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.InmuebleEntity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class ContrasenaDTO {
    
    @Id
    private String id;
    private String contrasena;
    private String horarioInicio;
    private String horarioFin;

    private ClienteEntity clienteC;
    private InmuebleEntity inmuebleC;
    
    public ContrasenaDTO() {
    }

    public ContrasenaDTO(String id, String contrasena, String horarioInicio, String horarioFin, ClienteEntity clienteC, InmuebleEntity inmuebleC) {
        this.id = id;
        this.contrasena = contrasena;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.clienteC = clienteC;
        this.inmuebleC = inmuebleC;
    }

    public ClienteEntity getClienteC() {
        return clienteC;
    }

    public void setClienteC(ClienteEntity clienteC) {
        this.clienteC = clienteC;
    }

    public InmuebleEntity getInmuebleC() {
        return inmuebleC;
    }

    public void setInmuebleC(InmuebleEntity inmuebleC) {
        this.inmuebleC = inmuebleC;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }
    
}
