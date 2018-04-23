package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "Inmueble")
public class InmuebleEntity implements Serializable{
    
    @Id
    private String id;
    private String direccion;
    private String torre;
    private String numero;

    @OneToOne(mappedBy="inmueble")
    private ClienteEntity cliente;
    
    @ManyToOne()
    private ResidenciaEntity residenciaI;
    
    @ManyToOne()
    private SeguridadEntity seguridadI;
    
    @OneToMany(mappedBy="inmuebleC")
    private List<ContrasenaEntity> contrasenaI;
    
    public InmuebleEntity() {
    }

    public InmuebleEntity(String id, String direccion, String torre, String numero, ClienteEntity cliente, ResidenciaEntity residenciaI, SeguridadEntity seguridadI, List<ContrasenaEntity> contrasenaI) {
        this.id = id;
        this.direccion = direccion;
        this.torre = torre;
        this.numero = numero;
        this.cliente = cliente;
        this.residenciaI = residenciaI;
        this.seguridadI = seguridadI;
        this.contrasenaI = contrasenaI;
    }

    public List<ContrasenaEntity> getContrasenaI() {
        return contrasenaI;
    }

    public void setContrasenaI(List<ContrasenaEntity> contrasenaI) {
        this.contrasenaI = contrasenaI;
    }

    
    public SeguridadEntity getSeguridadI() {
        return seguridadI;
    }

    public void setSeguridadI(SeguridadEntity seguridadI) {
        this.seguridadI = seguridadI;
    }

    
    public ResidenciaEntity getResidenciaI() {
        return residenciaI;
    }

    public void setResidenciaI(ResidenciaEntity residenciaI) {
        this.residenciaI = residenciaI;
    }
    
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
