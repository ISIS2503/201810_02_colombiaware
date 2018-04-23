package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "Admin")
public class AdminEntity implements Serializable{
    
    @Id
    private String id;
    private String nombre;
    
    @OneToOne(mappedBy="admin")
    private ResidenciaEntity residencia;

    public AdminEntity(String id, String nombre, ResidenciaEntity residencia) {
        this.id = id;
        this.nombre = nombre;
        this.residencia = residencia;
    }


    public AdminEntity() {
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
      
    public ResidenciaEntity getResidencia() {
        return residencia;
    }

    public void setResidencia(ResidenciaEntity residencia) {
        this.residencia = residencia;
    }
}
