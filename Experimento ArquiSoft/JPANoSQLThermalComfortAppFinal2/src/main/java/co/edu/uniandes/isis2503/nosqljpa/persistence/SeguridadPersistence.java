package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.SeguridadEntity;

/**
 *
 * @author ks.estupinan
 */
public class SeguridadPersistence extends Persistencer<SeguridadEntity, String>{
    
    public SeguridadPersistence(){
        this.entityClass = SeguridadEntity.class;
    }
}
