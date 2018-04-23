package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IInmuebleLogic {
    public InmuebleDTO add(InmuebleDTO dto);
    public InmuebleDTO update(InmuebleDTO dto);
    public InmuebleDTO find(String id);
    //Propietario y contrasena  public List<InmuebleDTO> allResidencia(String residencia);
    public InmuebleDTO findCode(String code);
    public List<InmuebleDTO> all();
    public Boolean delete(String id);
    
}
