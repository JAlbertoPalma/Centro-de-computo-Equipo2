/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dto.UnidadAcademicaDTO;
import entidad.UnidadAcademicaEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface IUnidadAcademicaDAO {
    public void guardar(UnidadAcademicaDTO unidadAcademicaDTO) throws PersistenciaException;
    
    public void actualizar(Long id, UnidadAcademicaDTO unidadAcademicaDTO) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public UnidadAcademicaEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<UnidadAcademicaEntidad> obtenerUnidadesAcademicas() throws PersistenciaException;
}
