/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.interfaces;
import java.time.LocalDate;
import java.util.List;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public interface IReporteDAO {
    public void reporteCentroComputo(LocalDate fechaInicio, LocalDate fechaFin, List<Long> ids_carreras, Long idLaboratorioComputo) throws PersistenciaException;
    
    public void reporteCarreras(LocalDate fechaInicio, LocalDate fechaFin, List<Long> ids_carreras) throws PersistenciaException;
    
    public void reporteBloqueos(LocalDate fechaInicio, LocalDate fechaFin)throws PersistenciaException;
}
