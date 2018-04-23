package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "Contrasena")
public class ContrasenaEntity implements Serializable{
    
    @Id
    private String id;
    private String contrasena;
    private String horarioInicio;
    private String horarioFin;
    
    @ManyToOne()
    private ClienteEntity clienteC;
    
    @ManyToOne()
    private InmuebleEntity inmuebleC;

    public ContrasenaEntity() {
    }

    public ContrasenaEntity(String id, String contrasena, String horarioInicio, String horarioFin, ClienteEntity clienteC, InmuebleEntity inmuebleC) {
        this.id = id;
        this.contrasena = contrasena;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.clienteC = clienteC;
        this.inmuebleC = inmuebleC;
    }

    public InmuebleEntity getInmuebleC() {
        return inmuebleC;
    }

    public void setInmuebleC(InmuebleEntity inmuebleC) {
        this.inmuebleC = inmuebleC;
    }

    
    public ClienteEntity getClienteC() {
        return clienteC;
    }

    public void setClienteC(ClienteEntity clienteC) {
        this.clienteC = clienteC;
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
