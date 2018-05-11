/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.converter;

import dto.model.seguridadPrivadaDTO;
import entity.seguridadPrivadaEntity;
import interfaces.ISeguridadPrivadaConverter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public class seguridadPrivadaConverter implements ISeguridadPrivadaConverter{
    public static ISeguridadPrivadaConverter CONVERTER = new seguridadPrivadaConverter();

    public seguridadPrivadaConverter() {
    }

    @Override
    public seguridadPrivadaDTO entityToDto(seguridadPrivadaEntity entity) {
        seguridadPrivadaDTO dto = new seguridadPrivadaDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        return dto;
    }

    @Override
    public seguridadPrivadaEntity dtoToEntity(seguridadPrivadaDTO dto) {
        seguridadPrivadaEntity entity = new seguridadPrivadaEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    }

    @Override
    public List<seguridadPrivadaDTO> listEntitiesToListDTOs(List<seguridadPrivadaEntity> entities) {
        ArrayList<seguridadPrivadaDTO> dtos = new ArrayList<>();
        for (seguridadPrivadaEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<seguridadPrivadaEntity> listDTOsToListEntities(List<seguridadPrivadaDTO> dtos) {
        ArrayList<seguridadPrivadaEntity> entities = new ArrayList<>();
        for (seguridadPrivadaDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
