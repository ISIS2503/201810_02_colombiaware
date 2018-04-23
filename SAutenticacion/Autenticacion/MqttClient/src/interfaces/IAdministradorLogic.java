/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.model.administradorDTO;
import java.util.List;

/**
 *
 * @author cs.gomez
 */
public interface IAdministradorLogic {
 
    public administradorDTO add(administradorDTO dto);
    public administradorDTO update(administradorDTO dto);
    public administradorDTO find(String id);
    public administradorDTO findCode(String code);
    public List<administradorDTO> all();
    public Boolean delete(String id);
}
