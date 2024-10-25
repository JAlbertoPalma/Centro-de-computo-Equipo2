/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dto.CarreraDTO;
import dto.ComputadoraDTO;
import entidad.CarreraEntidad;
import entidad.ComputadoraEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface ICarreraDAO {
    public void guardar(CarreraDTO carreraDTO) throws PersistenciaException;
    
    public void actualizar(Long id, CarreraDTO carreraDTO) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public CarreraEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<CarreraEntidad> obtenerCarreras() throws PersistenciaException;
}
