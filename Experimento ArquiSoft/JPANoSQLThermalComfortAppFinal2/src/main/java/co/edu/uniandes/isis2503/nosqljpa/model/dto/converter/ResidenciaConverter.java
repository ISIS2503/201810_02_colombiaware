package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IResidenciaConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.ResidenciaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public class ResidenciaConverter implements IResidenciaConverter{
     
    public static IResidenciaConverter CONVERTERR = new ResidenciaConverter();

    public ResidenciaConverter() {
    }

    @Override
    public ResidenciaDTO entityToDto(ResidenciaEntity entity) {
        ResidenciaDTO dto = new ResidenciaDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDireccion(entity.getDireccion());
        dto.setCiudad(entity.getCiudad());
        dto.setAdmin(entity.getAdmin());
        dto.setInmuebleR(entity.getInmuebleR());
        return dto;
    }

    @Override
    public ResidenciaEntity dtoToEntity(ResidenciaDTO dto) {
        ResidenciaEntity entity = new ResidenciaEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDireccion(dto.getDireccion());
        entity.setCiudad(dto.getCiudad());
        entity.setAdmin(dto.getAdmin());
        entity.setInmuebleR(dto.getInmuebleR());
        return entity;
    }

    @Override
    public List<ResidenciaDTO> listEntitiesToListDTOs(List<ResidenciaEntity> entities) {
        ArrayList<ResidenciaDTO> dtos = new ArrayList<>();
        for (ResidenciaEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<ResidenciaEntity> listDTOsToListEntities(List<ResidenciaDTO> dtos) {
        ArrayList<ResidenciaEntity> entities = new ArrayList<>();
        for (ResidenciaDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
