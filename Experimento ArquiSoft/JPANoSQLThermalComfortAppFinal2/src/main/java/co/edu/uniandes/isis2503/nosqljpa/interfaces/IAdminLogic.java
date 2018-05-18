package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AdminDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IAdminLogic {
    public AdminDTO add(AdminDTO dto);
    public AdminDTO update(AdminDTO dto);
    public AdminDTO find(String id);
    public List<ResidenciaDTO> allResidencia(String residencia);
    public AdminDTO findCode(String code);
    public List<AdminDTO> all();
    public Boolean delete(String id);
    
}
