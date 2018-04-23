package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.InmuebleEntity;

/**
 *
 * @author ks.estupinan
 */
public class InmueblePersistence extends Persistencer<InmuebleEntity, String>{
    
    public InmueblePersistence(){
        this.entityClass = InmuebleEntity.class;
    }
}
