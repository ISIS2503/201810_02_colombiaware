package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IAdminConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AdminDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.AdminEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public class AdminConverter implements IAdminConverter{
     
    public static IAdminConverter CONVERTERA = new AdminConverter();

    public AdminConverter() {
    }

    @Override
    public AdminDTO entityToDto(AdminEntity entity) {
        AdminDTO dto = new AdminDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        dto.setResidencia(entity.getResidencia());
        return dto;
    }

    @Override
    public AdminEntity dtoToEntity(AdminDTO dto) {
        AdminEntity entity = new AdminEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setResidencia(dto.getResidencia());
        return entity;
    }

    @Override
    public List<AdminDTO> listEntitiesToListDTOs(List<AdminEntity> entities) {
        ArrayList<AdminDTO> dtos = new ArrayList<>();
        for (AdminEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<AdminEntity> listDTOsToListEntities(List<AdminDTO> dtos) {
        ArrayList<AdminEntity> entities = new ArrayList<>();
        for (AdminDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
