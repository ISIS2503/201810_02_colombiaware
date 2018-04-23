package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.AdminEntity;

/**
 *
 * @author ks.estupinan
 */
public class AdminPersistence extends Persistencer<AdminEntity, String>{
    
    public AdminPersistence(){
        this.entityClass = AdminEntity.class;
    }
}
