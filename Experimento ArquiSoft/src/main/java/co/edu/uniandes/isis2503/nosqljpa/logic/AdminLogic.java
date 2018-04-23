package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IAdminLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.AdminConverter.CONVERTERA;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.ResidenciaConverter.CONVERTERR;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AdminDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.AdminPersistence;
import co.edu.uniandes.isis2503.nosqljpa.persistence.ResidenciaPersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ks.estupinan
 */
public class AdminLogic implements IAdminLogic{

    private final AdminPersistence persistence;
    private final ResidenciaPersistence persistenceR;

    public AdminLogic() {
        this.persistence = new AdminPersistence();
        this.persistenceR = new ResidenciaPersistence();
    }

    @Override
    public AdminDTO add(AdminDTO dto) {
         if(dto.getId()==null){
            dto.setId(UUID.randomUUID().toString());
         }
        AdminDTO result = CONVERTERA.entityToDto(persistence.add(CONVERTERA.dtoToEntity(dto)));
        return result;
    }

    @Override
    public AdminDTO update(AdminDTO dto) {
        AdminDTO result = CONVERTERA.entityToDto(persistence.update(CONVERTERA.dtoToEntity(dto)));
        return result;
    }

    @Override
    public AdminDTO find(String id) {
        return CONVERTERA.entityToDto(persistence.find(id));
    }
    
    @Override
    public List<ResidenciaDTO> allResidencia(String residencia) {
        return CONVERTERR.listEntitiesToListDTOs(persistenceR.findResidencia(residencia));
    }
    
    @Override
    public AdminDTO findCode(String code) {
        return CONVERTERA.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<AdminDTO> all() {
        return CONVERTERA.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
