package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.YaleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.YaleEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IYaleConverter {
    public YaleDTO entityToDto(YaleEntity entity);

    public YaleEntity dtoToEntity(YaleDTO dto);

    public List<YaleDTO> listEntitiesToListDTOs(List<YaleEntity> entities);

    public List<YaleEntity> listDTOsToListEntities(List<YaleDTO> dtos);
    
}
