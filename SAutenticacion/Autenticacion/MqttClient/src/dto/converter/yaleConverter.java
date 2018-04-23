/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.converter;

import dto.model.yaleDTO;
import entity.yaleEntity;
import interfaces.IYaleConverter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public class yaleConverter implements IYaleConverter{
    public static IYaleConverter CONVERTER = new yaleConverter();

    public yaleConverter() {
    }

    @Override
    public yaleDTO entityToDto(yaleEntity entity) {
        yaleDTO dto = new yaleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        return dto;
    }

    @Override
    public yaleEntity dtoToEntity(yaleDTO dto) {
        yaleEntity entity = new yaleEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }

    @Override
    public List<yaleDTO> listEntitiesToListDTOs(List<yaleEntity> entities) {
        ArrayList<yaleDTO> dtos = new ArrayList<>();
        for (yaleEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<yaleEntity> listDTOsToListEntities(List<yaleDTO> dtos) {
        ArrayList<yaleEntity> entities = new ArrayList<>();
        for (yaleDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
