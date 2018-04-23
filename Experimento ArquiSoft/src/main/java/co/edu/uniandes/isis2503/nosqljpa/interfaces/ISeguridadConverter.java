package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SeguridadDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.SeguridadEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface ISeguridadConverter {
    public SeguridadDTO entityToDto(SeguridadEntity entity);

    public SeguridadEntity dtoToEntity(SeguridadDTO dto);

    public List<SeguridadDTO> listEntitiesToListDTOs(List<SeguridadEntity> entities);

    public List<SeguridadEntity> listDTOsToListEntities(List<SeguridadDTO> dtos);
    
}
