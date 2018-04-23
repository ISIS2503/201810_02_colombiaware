package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.ResidenciaEntity;

/**
 *
 * @author ks.estupinan
 */
public class ResidenciaPersistence extends Persistencer<ResidenciaEntity, String>{
    
    public ResidenciaPersistence(){
        this.entityClass = ResidenciaEntity.class;
    }
}
