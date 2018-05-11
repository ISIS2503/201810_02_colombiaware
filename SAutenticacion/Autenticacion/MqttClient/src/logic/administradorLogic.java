/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import static dto.converter.administradorConverter.CONVERTER;
import dto.model.administradorDTO;
import interfaces.IAdministradorLogic;
import java.util.List;
import java.util.UUID;
import persistence.administradorPersistence;

/**
 *
 * @author cs.gomez
 */
public class administradorLogic implements IAdministradorLogic{

    private final administradorPersistence persistence;

    public administradorLogic() {
        this.persistence = new administradorPersistence();
    }

    @Override
    public administradorDTO add(administradorDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        administradorDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public administradorDTO update(administradorDTO dto) {
        administradorDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public administradorDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public administradorDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<administradorDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
