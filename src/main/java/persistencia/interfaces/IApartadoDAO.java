/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;

import entidad.ApartadoEntidad;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface IApartadoDAO {
    public void apartar(Long id_estudiante, Long id_computadora) throws PersistenciaException;

    public void desapartar(Long id) throws PersistenciaException;
    
    public void actualizarEntidad(ApartadoEntidad apartadoEntidad) throws PersistenciaException;
    
    public ApartadoEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<ApartadoEntidad> obtenerApartados() throws PersistenciaException;
}
