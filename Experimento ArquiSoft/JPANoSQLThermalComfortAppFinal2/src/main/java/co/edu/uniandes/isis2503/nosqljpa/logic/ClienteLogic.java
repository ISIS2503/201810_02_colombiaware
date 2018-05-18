package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IClienteLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ClienteConverter.CONVERTER;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ContrasenaConverter.CONVERTERC;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ClienteDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.ClientePersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.ContrasenaPersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.InmueblePersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class ClienteLogic implements IClienteLogic{

    private final ClientePersistence persistence;
    private final InmueblePersistence persistenceI;
    private final ContrasenaPersistence persistenceC;

    public ClienteLogic() {
        this.persistence = new ClientePersistence();
        this.persistenceI = new InmueblePersistence();
        this.persistenceC = new ContrasenaPersistence();
    }

    @Override
    public ClienteDTO add(ClienteDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        ClienteDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public ClienteDTO update(ClienteDTO dto) {
        ClienteDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public ClienteDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public ClienteDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<ClienteDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }

    @Override
    public InmuebleDTO allInmueble(String inmueble) {
        return CONVERTERI.entityToDto(persistenceI.getInmueble(inmueble));
    }

    @Override
    public ContrasenaDTO allContrasena(String contrasena) {
        //return CONVERTERC.entityToDto(persistenceC.gw(contrasena));
        return null;
    }
}
