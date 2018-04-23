package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IContrasenaLogic {
    public ContrasenaDTO add(ContrasenaDTO dto);
    public ContrasenaDTO update(ContrasenaDTO dto);
    public ContrasenaDTO find(String id);
    //public List<ContrasenaDTO> allInmueble(String inmueble);
    public ContrasenaDTO findCode(String code);
    public List<ContrasenaDTO> all();
    public Boolean delete(String id);
    
}
