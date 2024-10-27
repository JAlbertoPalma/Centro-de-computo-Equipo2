package negocio.interfaces;

import dto.EstudianteDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Brandon Valenzuela
 */
public interface IEstudianteNegocio {

    EstudianteDTO registrarEstudiante(EstudianteDTO estudiante) throws NegocioException;

    EstudianteDTO obtenerEstudiante(Long id) throws NegocioException;
    
    List<EstudianteDTO> ObtenerListaEstudiantes();

    void eliminarEstudiante(Long id) throws NegocioException;

    void actualizarEstudiante(EstudianteDTO estudiante) throws NegocioException;

    boolean validarContrasena(Long id, String contrasena) throws NegocioException;

}
