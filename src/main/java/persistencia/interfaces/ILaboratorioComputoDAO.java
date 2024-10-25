/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import dto.EstudianteDTO;
import dto.LaboratorioComputoDTO;
import entidad.EstudianteEntidad;
import entidad.LaboratorioComputoEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface ILaboratorioComputoDAO {
    public void guardar(LaboratorioComputoDTO laboratorioComputoDTO) throws PersistenciaException;
    
    public void actualizar(Long id, LaboratorioComputoDTO laboratorioDTO) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public LaboratorioComputoEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<LaboratorioComputoEntidad> obtenerLaboratoriosComputo() throws PersistenciaException;
    
}
