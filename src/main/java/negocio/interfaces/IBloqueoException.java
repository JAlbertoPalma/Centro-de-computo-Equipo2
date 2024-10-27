/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.interfaces;

import dto.BloqueoDTO;
import java.util.List;

/**
 *
 * @author Brandon Valenzuela
 */
public interface IBloqueoException {

    BloqueoDTO crearBloqueo(BloqueoDTO bloqueo) throws Exception;

    BloqueoDTO obtenerBloqueo(Long id) throws Exception;
    
    List<BloqueoDTO> obtenerListaBloqueos();

    void eliminarBloqueo(Long id) throws Exception;
}
