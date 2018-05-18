package co.edu.uniandes.isis2503.nosqljpa.interfaces;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ResidenciaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.VirtualEntityDTO;
import java.util.List;
/**
 *
 * @author ks.estupinan
 */
public interface IVirtualEntityLogic {
    public VirtualEntityDTO add(VirtualEntityDTO dto);
    public VirtualEntityDTO update(VirtualEntityDTO dto);
    public VirtualEntityDTO find(String id);
    public List<ResidenciaDTO> allResidencia(String residencia);
    public List<VirtualEntityDTO> allCiudad(String ciudad);
    public List<VirtualEntityDTO> allInmueble(String inmueble);
    public VirtualEntityDTO findCode(String code);
    public List<VirtualEntityDTO> all();
    public Boolean delete(String id);
}
