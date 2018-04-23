/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.propietarioDTO;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface IPropietarioLogic {
    
    public propietarioDTO add(propietarioDTO dto);
    public propietarioDTO update(propietarioDTO dto);
    public propietarioDTO find(String id);
    public propietarioDTO findCode(String code);
    public List<propietarioDTO> all();
    public Boolean delete(String id);
}
