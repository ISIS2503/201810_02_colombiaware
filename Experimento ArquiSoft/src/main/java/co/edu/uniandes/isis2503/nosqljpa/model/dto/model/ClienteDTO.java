package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.ContrasenaEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.InmuebleEntity;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.YaleEntity;
import java.util.List;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class ClienteDTO {
    
    @Id
    private String id;
    private String nombre;
    private String correo;
    
    private InmuebleEntity inmueble;
    
    private YaleEntity yaleC;
    
    private List<ContrasenaEntity> contrasenaC;

    public ClienteDTO() {
    }

    public ClienteDTO(String id, String nombre, String correo, InmuebleEntity inmueble, YaleEntity yaleC, List<ContrasenaEntity> contrasenaC) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.inmueble = inmueble;
        this.yaleC = yaleC;
        this.contrasenaC = contrasenaC;
    }

    public InmuebleEntity getInmueble() {
        return inmueble;
    }

    public void setInmueble(InmuebleEntity inmueble) {
        this.inmueble = inmueble;
    }

    public YaleEntity getYaleC() {
        return yaleC;
    }

    public void setYaleC(YaleEntity yaleC) {
        this.yaleC = yaleC;
    }

    public List<ContrasenaEntity> getContrasenaC() {
        return contrasenaC;
    }

    public void setContrasenaC(List<ContrasenaEntity> contrasenaC) {
        this.contrasenaC = contrasenaC;
    }
    
    public void setContrasena(ContrasenaEntity contrasenaC) {
        this.contrasenaC.add(contrasenaC);
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
