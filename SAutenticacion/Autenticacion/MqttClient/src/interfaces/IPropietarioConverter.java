/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.propietarioDTO;
import entity.propietarioEntity;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface IPropietarioConverter {
    
    public propietarioDTO entityToDto(propietarioEntity entity);

    public propietarioEntity dtoToEntity(propietarioDTO dto);

    public List<propietarioDTO> listEntitiesToListDTOs(List<propietarioEntity> entities);

    public List<propietarioEntity> listDTOsToListEntities(List<propietarioDTO> dtos);
}
