package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SeguridadDTO;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface ISeguridadLogic {
    public SeguridadDTO add(SeguridadDTO dto);
    public SeguridadDTO update(SeguridadDTO dto);
    public SeguridadDTO find(String id);
    public List<InmuebleDTO> allInmueble(String inmueble);
    public SeguridadDTO findCode(String code);
    public List<SeguridadDTO> all();
    public Boolean delete(String id);
    
}
