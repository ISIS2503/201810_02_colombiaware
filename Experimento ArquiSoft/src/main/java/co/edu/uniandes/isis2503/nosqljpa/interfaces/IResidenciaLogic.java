package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.InmuebleDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IResidenciaLogic {
    public ResidenciaDTO add(ResidenciaDTO dto);
    public ResidenciaDTO update(ResidenciaDTO dto);
    public ResidenciaDTO find(String id);
    public List<InmuebleDTO> allInmueble(String inmueble);
    public ResidenciaDTO findCode(String code);
    public List<ResidenciaDTO> all();
    public Boolean delete(String id);
    
}
