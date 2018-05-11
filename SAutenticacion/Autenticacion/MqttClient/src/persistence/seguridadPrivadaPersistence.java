/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.seguridadPrivadaEntity;

/**
 *
 * @author cs.gomez
 */
public class seguridadPrivadaPersistence extends Persistencer<seguridadPrivadaEntity, String>{

    public seguridadPrivadaPersistence(){
        this.entityClass = seguridadPrivadaEntity.class;
    }

}
