/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.administradorDTO;
import entity.administradorEntity;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface IAdministradorConverter {
    
    public administradorDTO entityToDto(administradorEntity entity);

    public administradorEntity dtoToEntity(administradorDTO dto);

    public List<administradorDTO> listEntitiesToListDTOs(List<administradorEntity> entities);

    public List<administradorEntity> listDTOsToListEntities(List<administradorDTO> dtos);
}
