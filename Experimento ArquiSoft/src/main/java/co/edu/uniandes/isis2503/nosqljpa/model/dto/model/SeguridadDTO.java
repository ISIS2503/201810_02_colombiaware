package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.InmuebleEntity;
import java.util.List;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class SeguridadDTO {
    
    @Id
    private String id;
    private String correo;
    private List<InmuebleEntity> inmuebleS;

    public SeguridadDTO() {
    }

    public SeguridadDTO(String id, String correo, List<InmuebleEntity> inmuebleS) {
        this.id = id;
        this.correo = correo;
        this.inmuebleS = inmuebleS;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
