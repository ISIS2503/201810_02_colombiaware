package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ContrasenaEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IContrasenaConverter {
    public ContrasenaDTO entityToDto(ContrasenaEntity entity);

    public ContrasenaEntity dtoToEntity(ContrasenaDTO dto);

    public List<ContrasenaDTO> listEntitiesToListDTOs(List<ContrasenaEntity> entities);

    public List<ContrasenaEntity> listDTOsToListEntities(List<ContrasenaDTO> dtos);
    
}
