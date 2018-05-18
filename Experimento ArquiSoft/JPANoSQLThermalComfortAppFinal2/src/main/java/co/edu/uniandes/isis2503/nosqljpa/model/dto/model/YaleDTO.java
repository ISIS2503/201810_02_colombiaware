package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.ClienteEntity;
import java.util.List;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class YaleDTO {
    
    @Id
    private String id;
    private String nombreSupervisor;
    private String correo;
    
    private List<ClienteEntity> clienteY;

    public YaleDTO() {
    }

    public YaleDTO(String id, String nombreSupervisor, String correo, List<ClienteEntity> clienteY) {
        this.id = id;
        this.nombreSupervisor = nombreSupervisor;
        this.correo = correo;
        this.clienteY = clienteY;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public List<ClienteEntity> getClienteY() {
        return clienteY;
    }

    public void setClienteY(List<ClienteEntity> clienteY) {
        this.clienteY = clienteY;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreSupervisor() {
        return nombreSupervisor;
    }

    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
    }
    
}
