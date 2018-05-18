package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IInmuebleLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.InmueblePersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class InmuebleLogic  implements IInmuebleLogic{

    private final InmueblePersistence persistence;

    public InmuebleLogic() {
        this.persistence = new InmueblePersistence();
    }

    @Override
    public InmuebleDTO add(InmuebleDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        InmuebleDTO result = CONVERTERI.entityToDto(persistence.add(CONVERTERI.dtoToEntity(dto)));
        return result;
    }

    @Override
    public InmuebleDTO update(InmuebleDTO dto) {
        InmuebleDTO result = CONVERTERI.entityToDto(persistence.update(CONVERTERI.dtoToEntity(dto)));
        return result;
    }

    @Override
    public InmuebleDTO find(String id) {
        return CONVERTERI.entityToDto(persistence.find(id));
    }
    
    @Override
    public InmuebleDTO findCode(String code) {
        return CONVERTERI.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<InmuebleDTO> all() {
        return CONVERTERI.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
