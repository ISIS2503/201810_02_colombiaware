package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ks.estupinan
 */
@XmlRootElement
public class VirtualEntityDTO {
    
    @Id
    private String id;
    private String cr;
    private String cd;
    private String asunto;
    private String cuerpo;
    private String pais;
    private String ciudad;
    private String residencia;
    private String inmueble;
    private String idDisp;
    
    public VirtualEntityDTO() {
    }

    public VirtualEntityDTO(String id, String cr, String cd, String asunto, String cuerpo, String pais, String ciudad, String residencia, String inmueble, String idDisp) {
        this.id = id;
        this.cr = cr;
        this.cd = cd;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.residencia = residencia;
        this.inmueble = inmueble;
        this.idDisp = idDisp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }
    
    public String getIdDisp() {
        return idDisp;
    }

    public void setIdDisp(String idDisp) {
        this.idDisp = idDisp;
    }
}
