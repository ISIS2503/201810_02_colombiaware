package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IInmuebleConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.InmuebleEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public class InmuebleConverter implements IInmuebleConverter{
     
    public static IInmuebleConverter CONVERTERI = new InmuebleConverter();

    public InmuebleConverter() {
    }

    @Override
    public InmuebleDTO entityToDto(InmuebleEntity entity) {
        InmuebleDTO dto = new InmuebleDTO();
        dto.setId(entity.getId());
        dto.setDireccion(entity.getDireccion());
        dto.setTorre(entity.getTorre());
        dto.setNumero(entity.getNumero());
        dto.setCliente(entity.getCliente());
        dto.setResidenciaI(entity.getResidenciaI());
        dto.setSeguridadI(entity.getSeguridadI());
        dto.setContrasenaI(entity.getContrasenaI());
        dto.setIdDispositivo(entity.getIdDispositivo());
        return dto;
    }

    @Override
    public InmuebleEntity dtoToEntity(InmuebleDTO dto) {
        InmuebleEntity entity = new InmuebleEntity();
        entity.setId(dto.getId());
        entity.setDireccion(dto.getDireccion());
        entity.setTorre(dto.getTorre());
        entity.setNumero(dto.getNumero());
        entity.setCliente(dto.getCliente());
        entity.setResidenciaI(dto.getResidenciaI());
        entity.setSeguridadI(dto.getSeguridadI());
        entity.setContrasenaI(dto.getContrasenaI());
        entity.setIdDispositivo(dto.getIdDispositivo());
        return entity;
    }

    @Override
    public List<InmuebleDTO> listEntitiesToListDTOs(List<InmuebleEntity> entities) {
        ArrayList<InmuebleDTO> dtos = new ArrayList<>();
        for (InmuebleEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<InmuebleEntity> listDTOsToListEntities(List<InmuebleDTO> dtos) {
        ArrayList<InmuebleEntity> entities = new ArrayList<>();
        for (InmuebleDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
