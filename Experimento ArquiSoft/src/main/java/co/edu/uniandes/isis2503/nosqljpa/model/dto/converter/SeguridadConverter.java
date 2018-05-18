package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.ISeguridadConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SeguridadDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.SeguridadEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public class SeguridadConverter implements ISeguridadConverter{
     
    public static ISeguridadConverter CONVERTER = new SeguridadConverter();

    public SeguridadConverter() {
    }

    @Override
    public SeguridadDTO entityToDto(SeguridadEntity entity) {
        SeguridadDTO dto = new SeguridadDTO();
        dto.setId(entity.getId());
        dto.setCorreo(entity.getCorreo());
        dto.setInmuebleS(entity.getInmuebleS());
        return dto;
    }

    @Override
    public SeguridadEntity dtoToEntity(SeguridadDTO dto) {
        SeguridadEntity entity = new SeguridadEntity();
        entity.setId(dto.getId());
        entity.setCorreo(dto.getCorreo());
        entity.setInmuebleS(dto.getInmuebleS());
        return entity;
    }

    @Override
    public List<SeguridadDTO> listEntitiesToListDTOs(List<SeguridadEntity> entities) {
        ArrayList<SeguridadDTO> dtos = new ArrayList<>();
        for (SeguridadEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<SeguridadEntity> listDTOsToListEntities(List<SeguridadDTO> dtos) {
        ArrayList<SeguridadEntity> entities = new ArrayList<>();
        for (SeguridadDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
