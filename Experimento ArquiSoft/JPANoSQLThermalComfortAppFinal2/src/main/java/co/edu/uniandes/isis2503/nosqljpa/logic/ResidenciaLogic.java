package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IResidenciaLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ResidenciaConverter.CONVERTERR;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.InmuebleConverter.CONVERTERI;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.InmueblePersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.ResidenciaPersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class ResidenciaLogic implements IResidenciaLogic{

    private final ResidenciaPersistence persistence;
    private final InmueblePersistence persistenceI;

    public ResidenciaLogic() {
        this.persistence = new ResidenciaPersistence();
        this.persistenceI = new InmueblePersistence();
    }

    @Override
    public ResidenciaDTO add(ResidenciaDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        ResidenciaDTO result = CONVERTERR.entityToDto(persistence.add(CONVERTERR.dtoToEntity(dto)));
        return result;
    }

    @Override
    public ResidenciaDTO update(ResidenciaDTO dto) {
        ResidenciaDTO result = CONVERTERR.entityToDto(persistence.update(CONVERTERR.dtoToEntity(dto)));
        return result;
    }

    @Override
    public ResidenciaDTO find(String id) {
        return CONVERTERR.entityToDto(persistence.find(id));
    }
    
    @Override
    public ResidenciaDTO findCode(String code) {
        return CONVERTERR.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<ResidenciaDTO> all() {
        return CONVERTERR.listEntitiesToListDTOs(persistence.all());
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
