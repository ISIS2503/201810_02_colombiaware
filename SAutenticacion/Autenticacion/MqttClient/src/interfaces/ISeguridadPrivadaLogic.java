/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.seguridadPrivadaDTO;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface ISeguridadPrivadaLogic {
    
    public seguridadPrivadaDTO add(seguridadPrivadaDTO dto);
    public seguridadPrivadaDTO update(seguridadPrivadaDTO dto);
    public seguridadPrivadaDTO find(String id);
    public seguridadPrivadaDTO findCode(String code);
    public List<seguridadPrivadaDTO> all();
    public Boolean delete(String id);
}
