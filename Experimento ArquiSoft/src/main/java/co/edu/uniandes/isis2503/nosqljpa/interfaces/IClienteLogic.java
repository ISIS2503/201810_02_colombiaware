package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ClienteDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ContrasenaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IClienteLogic {
    public ClienteDTO add(ClienteDTO dto);
    public ClienteDTO update(ClienteDTO dto);
    public ClienteDTO find(String id);
    public InmuebleDTO allInmueble(String inmueble);
    public ContrasenaDTO allContrasena(String inmueble);
    public ClienteDTO findCode(String code);
    public List<ClienteDTO> all();
    public Boolean delete(String id);
    
}
