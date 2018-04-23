package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.VirtualEntity;
/**
 *
 * @author ks.estupinan
 */
public class VirtualEntityPersistence extends Persistencer<VirtualEntity, String> {
    
    
    public VirtualEntityPersistence(){
        this.entityClass = VirtualEntity.class;
    }
    
}
