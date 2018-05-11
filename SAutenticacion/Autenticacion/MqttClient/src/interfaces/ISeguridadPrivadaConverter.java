/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.seguridadPrivadaDTO;
import entity.seguridadPrivadaEntity;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface ISeguridadPrivadaConverter {
    
    public seguridadPrivadaDTO entityToDto(seguridadPrivadaEntity entity);

    public seguridadPrivadaEntity dtoToEntity(seguridadPrivadaDTO dto);

    public List<seguridadPrivadaDTO> listEntitiesToListDTOs(List<seguridadPrivadaEntity> entities);

    public List<seguridadPrivadaEntity> listDTOsToListEntities(List<seguridadPrivadaDTO> dtos);
}
