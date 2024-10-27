/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import entidad.EstudianteBloqueoEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 * define un contrato para las operaciones CRUD
 * sobre el DAO del bloqueo asociado a un estudiante
 * @author Beto_
 */
public interface IEstudianteBloqueoDAO {
    public void bloquear(Long id_estudiante, Long id_bloqueo) throws PersistenciaException;

    public void desbloquear(Long id) throws PersistenciaException;
    
    public void actualizarEntidad(EstudianteBloqueoEntidad estudianteBloqueoEntidad) throws PersistenciaException;
    
    public EstudianteBloqueoEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<EstudianteBloqueoEntidad> obtenerApartados() throws PersistenciaException;
}
