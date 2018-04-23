package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.YaleDTO;
import java.util.List;

/**
 *
 * @author ks.estupinan
 */
public interface IYaleLogic {
    public YaleDTO add(YaleDTO dto);
    public YaleDTO update(YaleDTO dto);
    public YaleDTO find(String id);
    public List<YaleDTO> allResidencia(String residencia);
    public List<YaleDTO> allCiudad(String ciudad);
    public List<YaleDTO> allInmueble(String inmueble);
    public YaleDTO findCode(String code);
    public List<YaleDTO> all();
    public Boolean delete(String id);
    
}
