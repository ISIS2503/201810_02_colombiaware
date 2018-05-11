/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author cs.gomez
 */
@Entity
public class propietarioEntity implements Serializable{
    
    @Id
    private String id;
    private String name;
    private String code;
    
    public propietarioEntity(){
    }
    public propietarioEntity(String pid, String pname, String pcode){
        this.id = pid;
        this.name = pname;
        this.code = pcode;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
