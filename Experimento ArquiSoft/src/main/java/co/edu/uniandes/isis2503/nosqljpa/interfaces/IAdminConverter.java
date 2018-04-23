package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AdminDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.AdminEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IAdminConverter {
    public AdminDTO entityToDto(AdminEntity entity);

    public AdminEntity dtoToEntity(AdminDTO dto);

    public List<AdminDTO> listEntitiesToListDTOs(List<AdminEntity> entities);

    public List<AdminEntity> listDTOsToListEntities(List<AdminDTO> dtos);
    
}
