/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import static dto.converter.seguridadPrivadaConverter.CONVERTER;
import dto.model.seguridadPrivadaDTO;
import interfaces.ISeguridadPrivadaLogic;
import java.util.List;
import java.util.UUID;
import persistence.seguridadPrivadaPersistence;

/**
 *
 * @author cs.gomez
 */
public class seguridadPrivadaLogic implements ISeguridadPrivadaLogic{

    private final seguridadPrivadaPersistence persistence;

    public seguridadPrivadaLogic() {
        this.persistence = new seguridadPrivadaPersistence();
    }

    @Override
    public seguridadPrivadaDTO add(seguridadPrivadaDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        seguridadPrivadaDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public seguridadPrivadaDTO update(seguridadPrivadaDTO dto) {
        seguridadPrivadaDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public seguridadPrivadaDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public seguridadPrivadaDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<seguridadPrivadaDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
