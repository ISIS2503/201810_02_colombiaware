package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ClienteDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ClienteEntity;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IClienteConverter {
    public ClienteDTO entityToDto(ClienteEntity entity);

    public ClienteEntity dtoToEntity(ClienteDTO dto);

    public List<ClienteDTO> listEntitiesToListDTOs(List<ClienteEntity> entities);

    public List<ClienteEntity> listDTOsToListEntities(List<ClienteDTO> dtos);
}
