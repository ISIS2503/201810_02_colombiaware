/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.propietarioEntity;

/**
 *
 * @author cs.gomez
 */
public class propietarioPersistence extends Persistencer<propietarioEntity, String>{

    public propietarioPersistence(){
        this.entityClass = propietarioEntity.class;
    }

}
