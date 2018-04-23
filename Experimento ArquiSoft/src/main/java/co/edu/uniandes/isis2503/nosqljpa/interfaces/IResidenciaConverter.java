package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ResidenciaEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IResidenciaConverter {
    public ResidenciaDTO entityToDto(ResidenciaEntity entity);

    public ResidenciaEntity dtoToEntity(ResidenciaDTO dto);

    public List<ResidenciaDTO> listEntitiesToListDTOs(List<ResidenciaEntity> entities);

    public List<ResidenciaEntity> listDTOsToListEntities(List<ResidenciaDTO> dtos);
    
}
