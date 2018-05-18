package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.ISeguridadLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.SeguridadConverter.CONVERTER;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SeguridadDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.InmueblePersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.SeguridadPersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class SeguridadLogic implements ISeguridadLogic{

    private final SeguridadPersistence persistence;
    private final InmueblePersistence persistenceI;

    public SeguridadLogic() {
        this.persistence = new SeguridadPersistence();
        this.persistenceI = new InmueblePersistence();
    }

    @Override
    public SeguridadDTO add(SeguridadDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        SeguridadDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public SeguridadDTO update(SeguridadDTO dto) {
        SeguridadDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public SeguridadDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public SeguridadDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<SeguridadDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }

    @Override
    public List<InmuebleDTO> allInmueble(String inmueble) {
        return CONVERTERI.listEntitiesToListDTOs(persistenceI.findInmueble(inmueble));
    }
}
