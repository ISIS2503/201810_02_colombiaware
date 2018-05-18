package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.VirtualEntityDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.VirtualEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IVirtualEntityConverter {
    public VirtualEntityDTO entityToDto(VirtualEntity entity);

    public VirtualEntity dtoToEntity(VirtualEntityDTO dto);

    public List<VirtualEntityDTO> listEntitiesToListDTOs(List<VirtualEntity> entities);

    public List<VirtualEntity> listDTOsToListEntities(List<VirtualEntityDTO> dtos);
}
