package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "Cliente")
public class ClienteEntity implements Serializable{
    
    @Id
    private String id;
    private String nombre;
    private String correo;
    
    @OneToOne(mappedBy="cliente")
    private InmuebleEntity inmueble;
    
    @ManyToOne()
    private YaleEntity yaleC;
    
    @OneToMany(mappedBy="clienteC")
    private List<ContrasenaEntity> contrasenaC;
    
    public ClienteEntity(){
    }

    public ClienteEntity(String id, String nombre, String correo, InmuebleEntity inmueble, YaleEntity yaleC, List<ContrasenaEntity> contrasenaC) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.inmueble = inmueble;
        this.yaleC = yaleC;
        this.contrasenaC = contrasenaC;
    }

    public List<ContrasenaEntity> getContrasenaC() {
        return contrasenaC;
    }

    public void setContrasenaC(List<ContrasenaEntity> contrasenaC) {
        this.contrasenaC = contrasenaC;
    }
    
    public YaleEntity getYaleC() {
        return yaleC;
    }

    public void setYaleC(YaleEntity yaleC) {
        this.yaleC = yaleC;
    }

    
    public InmuebleEntity getInmueble() {
        return inmueble;
    }

    public void setInmueble(InmuebleEntity inmueble) {
        this.inmueble = inmueble;
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
