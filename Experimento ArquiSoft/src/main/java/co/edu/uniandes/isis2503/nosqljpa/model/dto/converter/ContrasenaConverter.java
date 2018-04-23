package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IContrasenaConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ContrasenaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public class ContrasenaConverter implements IContrasenaConverter{
     
    public static IContrasenaConverter CONVERTERC = new ContrasenaConverter();

    public ContrasenaConverter() {
    }

    @Override
    public ContrasenaDTO entityToDto(ContrasenaEntity entity) {
        ContrasenaDTO dto = new ContrasenaDTO();
        dto.setId(entity.getId());
        dto.setContrasena(entity.getContrasena());
        dto.setHorarioInicio(entity.getHorarioInicio());
        dto.setHorarioFin(entity.getHorarioFin());
        dto.setInmuebleC(entity.getInmuebleC());
        dto.setClienteC(entity.getClienteC());
        return dto;
    }

    @Override
    public ContrasenaEntity dtoToEntity(ContrasenaDTO dto) {
        ContrasenaEntity entity = new ContrasenaEntity();
        entity.setId(dto.getId());
        entity.setContrasena(dto.getContrasena());
        entity.setHorarioInicio(dto.getHorarioInicio());
        entity.setHorarioFin(dto.getHorarioFin());
        entity.setInmuebleC(dto.getInmuebleC());
        entity.setClienteC(dto.getClienteC());
        return entity;
    }

    @Override
    public List<ContrasenaDTO> listEntitiesToListDTOs(List<ContrasenaEntity> entities) {
        ArrayList<ContrasenaDTO> dtos = new ArrayList<>();
        for (ContrasenaEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<ContrasenaEntity> listDTOsToListEntities(List<ContrasenaDTO> dtos) {
        ArrayList<ContrasenaEntity> entities = new ArrayList<>();
        for (ContrasenaDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
