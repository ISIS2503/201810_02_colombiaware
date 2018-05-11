/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.converter.yaleConverter;
import dto.model.yaleDTO;
import interfaces.IYaleLogic;
import java.util.List;
import java.util.UUID;
import persistence.yalePersistence;
import static dto.converter.yaleConverter.CONVERTER;

/**
 *
 * @author cs.gomez
 */
public class yaleLogic implements IYaleLogic{

    private final yalePersistence persistence;

    public yaleLogic() {
        this.persistence = new yalePersistence();
    }

    @Override
    public yaleDTO add(yaleDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        yaleDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public yaleDTO update(yaleDTO dto) {
        yaleDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public yaleDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public yaleDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<yaleDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
