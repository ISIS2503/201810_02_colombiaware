package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IClienteConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ClienteDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ClienteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public class ClienteConverter implements IClienteConverter{
     
    public static IClienteConverter CONVERTER = new ClienteConverter();

    public ClienteConverter() {
    }

    @Override
    public ClienteDTO entityToDto(ClienteEntity entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        dto.setInmueble(entity.getInmueble());
        dto.setYaleC(entity.getYaleC());
        dto.setContrasenaC(entity.getContrasenaC());
        return dto;
    }

    @Override
    public ClienteEntity dtoToEntity(ClienteDTO dto) {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        return entity;
    }

    @Override
    public List<ClienteDTO> listEntitiesToListDTOs(List<ClienteEntity> entities) {
        ArrayList<ClienteDTO> dtos = new ArrayList<>();
        for (ClienteEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<ClienteEntity> listDTOsToListEntities(List<ClienteDTO> dtos) {
        ArrayList<ClienteEntity> entities = new ArrayList<>();
        for (ClienteDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
