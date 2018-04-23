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
@Table(name = "Seguridad")
public class SeguridadEntity implements Serializable{
    
    @Id
    private String id;

    @OneToMany(mappedBy = "seguridadI")
    private List<InmuebleEntity> inmuebleS;
    
    public SeguridadEntity() {
    }

    public SeguridadEntity(String id, List<InmuebleEntity> inmuebleS) {
        this.id = id;
        this.inmuebleS = inmuebleS;
    }

    public List<InmuebleEntity> getInmuebleS() {
        return inmuebleS;
    }

    public void setInmuebleS(List<InmuebleEntity> inmuebleS) {
        this.inmuebleS = inmuebleS;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
