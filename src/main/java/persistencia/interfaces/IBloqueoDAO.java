/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dto.BloqueoDTO;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface IBloqueoDAO {
    public void guardar(BloqueoDTO bloqueoDTO) throws PersistenciaException;
    
    public void actualizar(Long id, BloqueoDTO bloqueoDTO) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public BloqueoDTO obtenerPorId(Long id) throws PersistenciaException;
    
    public List<BloqueoDTO> obtenerBloqueos() throws PersistenciaException;
}
