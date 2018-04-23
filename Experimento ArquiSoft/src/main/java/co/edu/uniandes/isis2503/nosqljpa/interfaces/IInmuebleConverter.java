package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.InmuebleEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IInmuebleConverter {
    public InmuebleDTO entityToDto(InmuebleEntity entity);

    public InmuebleEntity dtoToEntity(InmuebleDTO dto);

    public List<InmuebleDTO> listEntitiesToListDTOs(List<InmuebleEntity> entities);

    public List<InmuebleEntity> listDTOsToListEntities(List<InmuebleDTO> dtos);
    
}
