package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.ResidenciaEntity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class AdminDTO {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private ResidenciaEntity residencia;

    public AdminDTO() {
    }

    public AdminDTO(String id, String nombre, String correo, ResidenciaEntity residencia) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.residencia = residencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    public ResidenciaEntity getResidencia() {
        return residencia;
    }

    public void setResidencia(ResidenciaEntity residencia) {
        this.residencia = residencia;
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
    
}
