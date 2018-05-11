/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.yaleDTO;
import entity.yaleEntity;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface IYaleConverter {
    
    public yaleDTO entityToDto(yaleEntity entity);

    public yaleEntity dtoToEntity(yaleDTO dto);

    public List<yaleDTO> listEntitiesToListDTOs(List<yaleEntity> entities);

    public List<yaleEntity> listDTOsToListEntities(List<yaleDTO> dtos);
}
