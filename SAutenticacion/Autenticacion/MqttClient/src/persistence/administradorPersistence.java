/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.administradorEntity;

/**
 *
 * @author cs.gomez
 */
public class administradorPersistence extends Persistencer<administradorEntity, String>{

    public administradorPersistence(){
        this.entityClass = administradorEntity.class;
    }

}
