package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.AdminEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ClienteEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ContrasenaEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ResidenciaEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.SeguridadEntity;
import java.util.List;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class InmuebleDTO {
    
    @Id
    private String id;
    private String direccion;
    private String torre;
    private String numero;
    
    private ClienteEntity cliente;
    private ResidenciaEntity residenciaI;
    private SeguridadEntity seguridadI;
    private List<ContrasenaEntity> contrasenaI;

    public InmuebleDTO() {
    }

    public InmuebleDTO(String id, String direccion, String torre, String numero, ClienteEntity cliente, ResidenciaEntity residenciaI, SeguridadEntity seguridadI, List<ContrasenaEntity> contrasenaI) {
        this.id = id;
        this.direccion = direccion;
        this.torre = torre;
        this.numero = numero;
        this.cliente = cliente;
        this.residenciaI = residenciaI;
        this.seguridadI = seguridadI;
        this.contrasenaI = contrasenaI;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public ResidenciaEntity getResidenciaI() {
        return residenciaI;
    }

    public void setResidenciaI(ResidenciaEntity residenciaI) {
        this.residenciaI = residenciaI;
    }

    public SeguridadEntity getSeguridadI() {
        return seguridadI;
    }

    public void setSeguridadI(SeguridadEntity seguridadI) {
        this.seguridadI = seguridadI;
    }

    public List<ContrasenaEntity> getContrasenaI() {
        return contrasenaI;
    }

    public void setContrasenaI(List<ContrasenaEntity> contrasenaI) {
        this.contrasenaI = contrasenaI;
    }
    public void setContrasena(ContrasenaEntity contrasenaI) {
        this.contrasenaI.add(contrasenaI);
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
