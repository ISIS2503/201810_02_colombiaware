/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.yaleEntity;

/**
 *
 * @author cs.gomez
 */
public class yalePersistence extends Persistencer<yaleEntity, String>{

    public yalePersistence(){
        this.entityClass = yaleEntity.class;
    }

}
