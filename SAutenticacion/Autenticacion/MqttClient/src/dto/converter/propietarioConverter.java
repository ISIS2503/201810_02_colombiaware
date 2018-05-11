/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.converter;

import dto.model.propietarioDTO;
import entity.propietarioEntity;
import interfaces.IPropietarioConverter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public class propietarioConverter implements IPropietarioConverter{
    public static IPropietarioConverter CONVERTER = new propietarioConverter();

    public propietarioConverter() {
    }

    @Override
    public propietarioDTO entityToDto(propietarioEntity entity) {
        propietarioDTO dto = new propietarioDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        return dto;
    }

    @Override
    public propietarioEntity dtoToEntity(propietarioDTO dto) {
        propietarioEntity entity = new propietarioEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }

    @Override
    public List<propietarioDTO> listEntitiesToListDTOs(List<propietarioEntity> entities) {
        ArrayList<propietarioDTO> dtos = new ArrayList<>();
        for (propietarioEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<propietarioEntity> listDTOsToListEntities(List<propietarioDTO> dtos) {
        ArrayList<propietarioEntity> entities = new ArrayList<>();
        for (propietarioDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
