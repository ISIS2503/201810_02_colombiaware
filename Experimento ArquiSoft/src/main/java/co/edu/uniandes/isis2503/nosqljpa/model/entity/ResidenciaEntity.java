package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "Residencia")
public class ResidenciaEntity implements Serializable{
    
    @Id
    private String id;
    private String nombre;
    private String direccion;
    
    @OneToOne(mappedBy="residencia")
    private AdminEntity admin;

    @OneToMany(mappedBy = "residenciaI")
    private List<InmuebleEntity> inmuebleR;
            
    public ResidenciaEntity() {
    }

    public ResidenciaEntity(String id, String nombre, String direccion, AdminEntity admin, List<InmuebleEntity> inmuebleR) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.admin = admin;
        this.inmuebleR = inmuebleR;
    }

    public List<InmuebleEntity> getInmuebleR() {
        return inmuebleR;
    }

    public void setInmuebleR(List<InmuebleEntity> inmuebleR) {
        this.inmuebleR = inmuebleR;
    }
        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public AdminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }
    
}
