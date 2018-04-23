package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IVirtualEntityConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.VirtualEntityDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.VirtualEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ks.estupinan
 */
public class VirtualEntityConverter implements IVirtualEntityConverter{
 
    public static IVirtualEntityConverter CONVERTER = new VirtualEntityConverter();

    public VirtualEntityConverter() {
    }

    @Override
    public VirtualEntityDTO entityToDto(VirtualEntity entity) {
        VirtualEntityDTO dto = new VirtualEntityDTO();
        dto.setId(entity.getId());
        dto.setCr(entity.getCr());
        dto.setCd(entity.getCd());
        dto.setAsunto(entity.getAsunto());
        dto.setCuerpo(entity.getCuerpo());
        dto.setPais(entity.getPais());
        dto.setCiudad(entity.getCiudad());
        dto.setResidencia(entity.getResidencia());
        dto.setInmueble(entity.getInmueble());
        dto.setIdDisp(entity.getIdDisp());
        return dto;
    }

    @Override
    public VirtualEntity dtoToEntity(VirtualEntityDTO dto) {
        VirtualEntity entity = new VirtualEntity();
        entity.setId(dto.getId());
        entity.setCr(dto.getCr());
        entity.setCd(dto.getCd());
        entity.setAsunto(dto.getAsunto());
        entity.setCuerpo(dto.getCuerpo());
        entity.setPais(dto.getPais());
        entity.setCiudad(dto.getCiudad());
        entity.setResidencia(dto.getResidencia());
        entity.setInmueble(dto.getInmueble());
        entity.setIdDisp(dto.getIdDisp());
        return entity;
    }

    @Override
    public List<VirtualEntityDTO> listEntitiesToListDTOs(List<VirtualEntity> entities) {
        ArrayList<VirtualEntityDTO> dtos = new ArrayList<>();
        for (VirtualEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<VirtualEntity> listDTOsToListEntities(List<VirtualEntityDTO> dtos) {
        ArrayList<VirtualEntity> entities = new ArrayList<>();
        for (VirtualEntityDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
