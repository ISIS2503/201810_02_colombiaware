package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IContrasenaLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ContrasenaConverter.CONVERTERC;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.PasswordEntity;
import co.edu.uniandes.isis2503.nosqljpa.persistence.ContrasenaPersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class ContrasenaLogic implements IContrasenaLogic{

    private final ContrasenaPersistence persistence;

    public ContrasenaLogic() {
        this.persistence = new ContrasenaPersistence();
    }
    public String contraseniasWiring(String horario)
    {
        PasswordEntity contra= persistence.buscarPorHorarioInicial(horario);
        PasswordEntity contra2= persistence.buscarPorHorarioFinal(horario);
        String resp;
        if(contra!=null)
        {
        String idC = contra.getId();
        String contrasenia = contra.getPassword();
        resp = "agregar:"+idC+":"+contrasenia;
        }
        else if(contra2!=null)
        {
        String idC = contra2.getId();
        String contrasenia = contra2.getPassword();
        resp = "borrar:"+idC+":"+contrasenia;
        }
        else
        {resp =null;
        }
        return resp;
    }

    @Override
    public ContrasenaDTO add(ContrasenaDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        ContrasenaDTO result = CONVERTERC.entityToDto(persistence.add(CONVERTERC.dtoToEntity(dto)));
        return result;
    }

    @Override
    public ContrasenaDTO update(ContrasenaDTO dto) {
        ContrasenaDTO result = CONVERTERC.entityToDto(persistence.update(CONVERTERC.dtoToEntity(dto)));
        return result;
    }

    @Override
    public ContrasenaDTO find(String id) {
        return CONVERTERC.entityToDto(persistence.find(id));
    }
    
    @Override
    public ContrasenaDTO findCode(String code) {
        return CONVERTERC.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<ContrasenaDTO> all() {
        return CONVERTERC.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
