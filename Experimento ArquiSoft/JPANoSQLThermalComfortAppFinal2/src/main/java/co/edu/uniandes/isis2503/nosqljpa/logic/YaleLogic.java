package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IYaleLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.YaleConverter.CONVERTER;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ResidenciaConverter.CONVERTERR;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.YaleDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.YalePersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class YaleLogic implements IYaleLogic{

    private final YalePersistence persistence;

    public YaleLogic() {
        this.persistence = new YalePersistence();
    }

    @Override
    public YaleDTO add(YaleDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        YaleDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public YaleDTO update(YaleDTO dto) {
        YaleDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public YaleDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public List<ResidenciaDTO> allResidencia(String residencia) {
        return CONVERTERR.listEntitiesToListDTOs(persistence.findResidencia(residencia));
    }
    
    @Override
    public YaleDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<YaleDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }

    @Override
    public List<YaleDTO> allCiudad(String ciudad) {
        return CONVERTER.listEntitiesToListDTOs(persistence.findCiudad(ciudad));
    }

    @Override
    public List<YaleDTO> allInmueble(String inmueble) {
        return CONVERTER.listEntitiesToListDTOs(persistence.findInmueble(inmueble));
    }
}
