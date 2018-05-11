/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.yaleDTO;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface IYaleLogic {
    
    public yaleDTO add(yaleDTO dto);
    public yaleDTO update(yaleDTO dto);
    public yaleDTO find(String id);
    public yaleDTO findCode(String code);
    public List<yaleDTO> all();
    public Boolean delete(String id);
}
