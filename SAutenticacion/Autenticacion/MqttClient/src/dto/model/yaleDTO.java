/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public class yaleDTO {
    
    private String id;
    private String name;
    private String code;

    public yaleDTO() {
    }

    public yaleDTO(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
