package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "Yale")
public class YaleEntity  implements Serializable {    
    @Id
    private String id;
    private String nombreSupervisor;

    @OneToMany(mappedBy = "yaleC")
    private List<ClienteEntity> clienteY;
    
    public YaleEntity() {
    }

    public YaleEntity(String id, String nombreSupervisor, List<ClienteEntity> clienteY) {
        this.id = id;
        this.nombreSupervisor = nombreSupervisor;
        this.clienteY = clienteY;
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
