package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.AdminEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.InmuebleEntity;
import java.util.List;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class ResidenciaDTO {
    
    @Id
    private String id;
    private String nombre;
    private String direccion;
        
    private AdminEntity admin;
    private List<InmuebleEntity> inmuebleR;

    public ResidenciaDTO() {
    }

    public ResidenciaDTO(String id, String nombre, String direccion, AdminEntity admin, List<InmuebleEntity> inmuebleR) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.admin = admin;
        this.inmuebleR = inmuebleR;
    }

    public AdminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }

    public List<InmuebleEntity> getInmuebleR() {
        return inmuebleR;
    }

    public void setInmuebleR(List<InmuebleEntity> inmuebleR) {
        this.inmuebleR = inmuebleR;
    }
    public void setInmueble(InmuebleEntity inmuebleR) {
        this.inmuebleR.add(inmuebleR);
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
    
}
