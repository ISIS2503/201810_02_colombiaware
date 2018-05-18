package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IYaleConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.YaleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.YaleEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public class YaleConverter implements IYaleConverter{
     
    public static IYaleConverter CONVERTER = new YaleConverter();

    public YaleConverter() {
    }

    @Override
    public YaleDTO entityToDto(YaleEntity entity) {
        YaleDTO dto = new YaleDTO();
        dto.setId(entity.getId());
        dto.setNombreSupervisor(entity.getNombreSupervisor());
        dto.setCorreo(entity.getCorreo());
        dto.setClienteY(entity.getClienteY());
        return dto;
    }

    @Override
    public YaleEntity dtoToEntity(YaleDTO dto) {
        YaleEntity entity = new YaleEntity();
        entity.setId(dto.getId());
        entity.setNombreSupervisor(dto.getNombreSupervisor());
        entity.setCorreo(dto.getCorreo());
        entity.setClienteY(dto.getClienteY());
        return entity;
    }

    @Override
    public List<YaleDTO> listEntitiesToListDTOs(List<YaleEntity> entities) {
        ArrayList<YaleDTO> dtos = new ArrayList<>();
        for (YaleEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<YaleEntity> listDTOsToListEntities(List<YaleDTO> dtos) {
        ArrayList<YaleEntity> entities = new ArrayList<>();
        for (YaleDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
