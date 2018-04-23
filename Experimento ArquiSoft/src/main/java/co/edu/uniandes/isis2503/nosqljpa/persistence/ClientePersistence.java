package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.ClienteEntity;

/**
 *
 * @author ks.estupinan
 */
public class ClientePersistence extends Persistencer<ClienteEntity, String>{
    
    public ClientePersistence(){
        this.entityClass = ClienteEntity.class;
    }
}
