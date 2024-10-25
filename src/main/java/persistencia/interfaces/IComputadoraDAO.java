/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dto.ComputadoraDTO;
import entidad.ComputadoraEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface IComputadoraDAO {
    public void guardar(ComputadoraDTO computadoraDTO, Long id_laboratorioComputo) throws PersistenciaException;
    
    public void actualizar(Long id, ComputadoraDTO computadoraDTO) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public ComputadoraEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<ComputadoraEntidad> obtenerComputadoras() throws PersistenciaException;
}
