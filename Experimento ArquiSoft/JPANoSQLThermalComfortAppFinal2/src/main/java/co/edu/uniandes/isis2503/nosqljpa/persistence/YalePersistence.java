package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.YaleEntity;

/**
 *
 * @author ks.estupinan
 */
public class YalePersistence extends Persistencer<YaleEntity, String>{
    
    public YalePersistence(){
        this.entityClass = YaleEntity.class;
    }
}
