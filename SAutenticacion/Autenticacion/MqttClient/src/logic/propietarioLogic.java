/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import static dto.converter.propietarioConverter.CONVERTER;
import dto.model.propietarioDTO;
import interfaces.IPropietarioLogic;
import java.util.List;
import java.util.UUID;
import persistence.propietarioPersistence;

/**
 *
 * @author cs.gomez
 */
public class propietarioLogic implements IPropietarioLogic{

    private final propietarioPersistence persistence;

    public propietarioLogic() {
        this.persistence = new propietarioPersistence();
    }

    @Override
    public propietarioDTO add(propietarioDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        propietarioDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public propietarioDTO update(propietarioDTO dto) {
        propietarioDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public propietarioDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public propietarioDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<propietarioDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
