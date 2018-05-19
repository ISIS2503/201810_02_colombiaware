/*
 * The MIT License
 *
 * Copyright 2017 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "INMUEBLE")
public class InmuebleEntity implements Serializable{
    
    @Id
    private String idDispositivo;
    private String direccion;
    private String torre;
    private String numero;
    private boolean estado;

    @OneToOne
    private ClienteEntity cliente;
    
    @ManyToOne
    private ResidenciaEntity residenciaI;
    
    @ManyToOne
    private SeguridadEntity seguridadI;
    
    @OneToMany(mappedBy="inmuebleC", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<PasswordEntity> contrasenaI;
    
    public InmuebleEntity() {
    }

    public InmuebleEntity(String idDispositivo, String direccion, String torre, String numero, boolean estado, ClienteEntity cliente, ResidenciaEntity residenciaI, SeguridadEntity seguridadI, List<PasswordEntity> contrasenaI) {
        this.idDispositivo = idDispositivo;
        this.direccion = direccion;
        this.torre = torre;
        this.numero = numero;
        this.estado = estado;
        this.cliente = cliente;
        this.residenciaI = residenciaI;
        this.seguridadI = seguridadI;
        this.contrasenaI = contrasenaI;
    }
    
    public List<PasswordEntity> getContrasenaI() {
        return contrasenaI;
    }

    public void setContrasenaI(List<PasswordEntity> contrasenaI) {
        this.contrasenaI = contrasenaI;
    }

    
    public SeguridadEntity getSeguridadI() {
        return seguridadI;
    }

    public void setSeguridadI(SeguridadEntity seguridadI) {
        this.seguridadI = seguridadI;
    }

    
    public ResidenciaEntity getResidenciaI() {
        return residenciaI;
    }

    public void setResidenciaI(ResidenciaEntity residenciaI) {
        this.residenciaI = residenciaI;
    }
    
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEsatdo(boolean estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }
    
}
