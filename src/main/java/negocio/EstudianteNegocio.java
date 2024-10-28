package negocio;

import dto.EstudianteDTO;
import entidad.EstudianteEntidad;
import negocio.convertidores.EstudianteCVR;
import negocio.exception.NegocioException;
import persistencia.EstudianteDAO;
import persistencia.interfaces.IEstudianteDAO;

import java.util.List;
import java.util.stream.Collectors;
import negocio.interfaces.IEstudianteNegocio;

/**
 * La clase EstudianteNegocio se encarga de la lógica de negocio relacionada
 * con los estudiantes. Utiliza el EstudianteDAO para realizar las operaciones
 * necesarias y el convertidor EstudianteCVR para manejar la conversión entre
 * las entidades y los DTO.
 * 
 * @author Brandon Valenzuela
 */
public class EstudianteNegocio implements IEstudianteNegocio {

    private IEstudianteDAO estudianteDAO;
    private EstudianteCVR estudianteCVR;

    /**
     * Constructor que inicializa el DAO de estudiantes y el convertidor.
     * 
     * @param estudianteDAO el DAO de estudiantes
     */
    public EstudianteNegocio(IEstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
        this.estudianteCVR = new EstudianteCVR();
    }

    /**
     * Registra un nuevo estudiante.
     * 
     * @param estudianteDTO el DTO del estudiante a registrar
     * @param idCarrera ID de la carrera a la que se registra el estudiante
     * @return el DTO del estudiante registrado
     * @throws NegocioException si ocurre un error al registrar el estudiante
     */
    @Override
    public EstudianteDTO registrarEstudiante(EstudianteDTO estudianteDTO, Long idCarrera) throws NegocioException {
        try {
            EstudianteEntidad estudianteEntidad = estudianteCVR.estudianteDTO_entidad(estudianteDTO);
            estudianteDAO.guardar(estudianteDTO, idCarrera);
            return estudianteCVR.entidad_estudianteDTO(estudianteEntidad);
        } catch (Exception e) {
            throw new NegocioException("Error al registrar el estudiante: " + e.getMessage());
        }
    }

    /**
     * Obtiene un estudiante por su ID.
     * 
     * @param id el ID del estudiante
     * @return el DTO del estudiante encontrado
     * @throws NegocioException si no se encuentra el estudiante
     */
    @Override
    public EstudianteDTO obtenerEstudiante(Long id) throws NegocioException {
        try {
            EstudianteEntidad estudianteEntidad = estudianteDAO.obtenerPorId(id);
            return estudianteCVR.entidad_estudianteDTO(estudianteEntidad);
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el estudiante: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de estudiantes.
     * 
     * @return la lista de estudiantes en formato DTO
     * @throws NegocioException si ocurre un error al obtener la lista
     */
    @Override
    public List<EstudianteDTO> ObtenerListaEstudiantes() throws NegocioException {
        try {
            List<EstudianteEntidad> estudiantesEntidad = estudianteDAO.obtenerEstudiantes();
            return estudiantesEntidad.stream()
                    .map(estudianteCVR::entidad_estudianteDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener la lista de estudiantes: " + e.getMessage());
        }
    }

    /**
     * Elimina un estudiante por su ID.
     * 
     * @param id el ID del estudiante a eliminar
     * @throws NegocioException si ocurre un error al eliminar el estudiante
     */
    @Override
    public void eliminarEstudiante(Long id) throws NegocioException {
        try {
            estudianteDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el estudiante: " + e.getMessage());
        }
    }

    /**
     * Actualiza un estudiante.
     * 
     * @param estudianteDTO el DTO del estudiante con los nuevos datos
     * @throws NegocioException si ocurre un error al actualizar el estudiante
     */
    @Override
    public void actualizarEstudiante(EstudianteDTO estudianteDTO) throws NegocioException {
        try {
            EstudianteEntidad estudianteEntidad = estudianteCVR.estudianteDTO_entidad(estudianteDTO);
            estudianteDAO.actualizarEntidad(estudianteEntidad);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el estudiante: " + e.getMessage());
        }
    }

    /**
     * Valida la contraseña de un estudiante.
     * 
     * @param id el ID del estudiante
     * @param contrasena la contraseña a validar
     * @return true si la contraseña es válida, false en caso contrario
     * @throws NegocioException si ocurre un error en la validación
     */
    @Override
    public boolean validarContrasena(Long id, String contrasena) throws NegocioException {
        try {
            EstudianteEntidad estudianteEntidad = estudianteDAO.obtenerPorId(id);
            return estudianteEntidad.getContrasena().equals(contrasena);
        } catch (Exception e) {
            throw new NegocioException("Error al validar la contraseña: " + e.getMessage());
        }
    }

}
