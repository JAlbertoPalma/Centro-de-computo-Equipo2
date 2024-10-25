/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dto.EstudianteDTO;
import entidad.EstudianteEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface IEstudianteDAO {
    public void guardar(EstudianteDTO estudianteDTO, Long id_carrera) throws PersistenciaException;
    
    public void actualizar(Long id, EstudianteDTO estudianteDTO) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public EstudianteEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<EstudianteEntidad> obtenerEstudiantes() throws PersistenciaException;
    
    
}
