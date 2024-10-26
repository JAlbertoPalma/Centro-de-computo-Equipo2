/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dto.BloqueoDTO;
import entidad.BloqueoEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface IBloqueoDAO {
    public void guardar(BloqueoDTO bloqueoDTO, Long id_laboratorioComputo) throws PersistenciaException;
    
    public void actualizar(Long id, BloqueoDTO bloqueoDTO) throws PersistenciaException;
    
    public void actualizarEntidad(BloqueoEntidad bloqueoEntidad) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public BloqueoEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<BloqueoEntidad> obtenerBloqueos() throws PersistenciaException;
}
