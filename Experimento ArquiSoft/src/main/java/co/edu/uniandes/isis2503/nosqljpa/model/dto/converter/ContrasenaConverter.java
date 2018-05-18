package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IContrasenaConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.PasswordEntity;
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
    public ContrasenaDTO entityToDto(PasswordEntity entity) {
        ContrasenaDTO dto = new ContrasenaDTO();
        dto.setId(entity.getId());
        dto.setContrasena(entity.getPassword());
        dto.setHorarioInicio(entity.getHorarioInicio());
        dto.setHorarioFin(entity.getHorarioFin());
        dto.setDias(entity.getDias());
        dto.setInmuebleC(entity.getInmuebleC());
        return dto;
    }

    @Override
    public PasswordEntity dtoToEntity(ContrasenaDTO dto) {
        PasswordEntity entity = new PasswordEntity();
        entity.setId(dto.getId());
        entity.setPassword(dto.getContrasena());
        entity.setHorarioInicio(dto.getHorarioInicio());
        entity.setHorarioFin(dto.getHorarioFin());
        dto.setDias(entity.getDias());
        entity.setInmuebleC(dto.getInmuebleC());
        return entity;
    }

    @Override
    public List<ContrasenaDTO> listEntitiesToListDTOs(List<PasswordEntity> entities) {
        ArrayList<ContrasenaDTO> dtos = new ArrayList<>();
        for (PasswordEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<PasswordEntity> listDTOsToListEntities(List<ContrasenaDTO> dtos) {
        ArrayList<PasswordEntity> entities = new ArrayList<>();
        for (ContrasenaDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
