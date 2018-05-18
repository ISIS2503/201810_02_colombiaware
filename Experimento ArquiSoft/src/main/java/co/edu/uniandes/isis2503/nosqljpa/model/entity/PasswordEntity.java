/*
 * The MIT License
 *
 * Copyright 2018 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ks.estupinan
 */
@Entity
@Table(name = "PASSWORD")
public class PasswordEntity implements Serializable {
    
    @Id
    private String id;
    private String password;
    
    private String horarioInicio;
    
    private String horarioFin;
    
    private String[] dias;
    
    @ManyToOne
    private InmuebleEntity inmuebleC;

    public PasswordEntity() {
        dias = new String[7];
    }
    //arreglo de dias[] lunes martes miercoles jueves viernes

    public PasswordEntity(String id, String password, String horarioInicio, String horarioFin, String[] dias, InmuebleEntity inmuebleC) {
        this.id = id;
        this.password = password;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.dias = dias;
        this.inmuebleC = inmuebleC;
    }

    public String[] getDias() {
        return dias;
    }

    public void setDias(String[] dias) {
        this.dias = dias;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

    public InmuebleEntity getInmuebleC() {
        return inmuebleC;
    }

    public void setInmuebleC(InmuebleEntity inmuebleC) {
        this.inmuebleC = inmuebleC;
    }
        
}
