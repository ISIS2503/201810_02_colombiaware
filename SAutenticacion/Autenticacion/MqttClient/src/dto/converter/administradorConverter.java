/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.converter;

import dto.model.administradorDTO;
import entity.administradorEntity;
import interfaces.IAdministradorConverter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public class administradorConverter implements IAdministradorConverter{
    public static IAdministradorConverter CONVERTER = new administradorConverter();

    public administradorConverter() {
    }

    @Override
    public administradorDTO entityToDto(administradorEntity entity) {
        administradorDTO dto = new administradorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        return dto;
    }

    @Override
    public administradorEntity dtoToEntity(administradorDTO dto) {
        administradorEntity entity = new administradorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }

    @Override
    public List<administradorDTO> listEntitiesToListDTOs(List<administradorEntity> entities) {
        ArrayList<administradorDTO> dtos = new ArrayList<>();
        for (administradorEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<administradorEntity> listDTOsToListEntities(List<administradorDTO> dtos) {
        ArrayList<administradorEntity> entities = new ArrayList<>();
        for (administradorDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
