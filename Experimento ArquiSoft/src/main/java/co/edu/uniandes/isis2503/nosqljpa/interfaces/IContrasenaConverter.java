package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.PasswordEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IContrasenaConverter {
    public ContrasenaDTO entityToDto(PasswordEntity entity);

    public PasswordEntity dtoToEntity(ContrasenaDTO dto);

    public List<ContrasenaDTO> listEntitiesToListDTOs(List<PasswordEntity> entities);

    public List<PasswordEntity> listDTOsToListEntities(List<ContrasenaDTO> dtos);
    
}
