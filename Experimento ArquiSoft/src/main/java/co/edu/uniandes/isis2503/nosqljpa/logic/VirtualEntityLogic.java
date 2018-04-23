package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IVirtualEntityLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.VirtualEntityConverter.CONVERTER;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.VirtualEntityDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.VirtualEntityPersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class VirtualEntityLogic implements IVirtualEntityLogic{

    private final VirtualEntityPersistence persistence;

    public VirtualEntityLogic() {
        this.persistence = new VirtualEntityPersistence();
    }

    @Override
    public VirtualEntityDTO add(VirtualEntityDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        VirtualEntityDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public VirtualEntityDTO update(VirtualEntityDTO dto) {
        VirtualEntityDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public VirtualEntityDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public List<VirtualEntityDTO> allResidencia(String residencia) {
        return CONVERTER.listEntitiesToListDTOs(persistence.findResidencia(residencia));
    }
    
    @Override
    public VirtualEntityDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<VirtualEntityDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }

    @Override
    public List<VirtualEntityDTO> allCiudad(String ciudad) {
        return CONVERTER.listEntitiesToListDTOs(persistence.findCiudad(ciudad));
    }

    @Override
    public List<VirtualEntityDTO> allInmueble(String inmueble) {
        return CONVERTER.listEntitiesToListDTOs(persistence.findInmueble(inmueble));
    }
}
