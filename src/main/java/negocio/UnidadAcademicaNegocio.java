package negocio;

import dto.UnidadAcademicaDTO;
import entidad.UnidadAcademicaEntidad;
import java.util.List;
import java.util.stream.Collectors;
import negocio.convertidores.UnidadAcademicaCVR;
import negocio.interfaces.IUnidadAcademicaNegocio;
import persistencia.UnidadAcademicaDAO;
import persistencia.PersistenciaException;

/**
 * La clase UnidadAcademicaNegocio implementa la lógica de negocio
 * para gestionar unidades académicas en el sistema.
 * Utiliza UnidadAcademicaDAO para realizar operaciones en la base de datos.
 * @author Brandon Valenzuela
 */
public class UnidadAcademicaNegocio implements IUnidadAcademicaNegocio {
    
    private final UnidadAcademicaDAO unidadAcademicaDAO;
    private final UnidadAcademicaCVR convertidor;

    /**
     * Constructor que recibe una instancia de UnidadAcademicaDAO y UnidadAcademicaCVR.
     * @param unidadAcademicaDAO DAO para realizar operaciones de persistencia.
     * @param convertidor Convertidor entre entidad y DTO.
     */
    public UnidadAcademicaNegocio(UnidadAcademicaDAO unidadAcademicaDAO, UnidadAcademicaCVR convertidor) {
        this.unidadAcademicaDAO = unidadAcademicaDAO;
        this.convertidor = convertidor;
    }

    /**
     * Crea una nueva unidad académica en la base de datos.
     * @param unidad UnidadAcademicaDTO con los datos de la nueva unidad académica.
     * @return UnidadAcademicaDTO de la unidad creada.
     * @throws Exception Si ocurre un error al guardar la unidad.
     */
    @Override
    public UnidadAcademicaDTO crearUnidadAcademica(UnidadAcademicaDTO unidad) throws Exception {
        try {
            unidadAcademicaDAO.guardar(unidad);
            return unidad;
        } catch (PersistenciaException e) {
            throw new Exception("Error al crear la unidad académica: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene una unidad académica por su ID.
     * @param id ID de la unidad académica a obtener.
     * @return UnidadAcademicaDTO con los datos de la unidad obtenida.
     * @throws Exception Si ocurre un error al obtener la unidad.
     */
    @Override
    public UnidadAcademicaDTO obtenerUnidadAcademica(Long id) throws Exception {
        try {
            UnidadAcademicaEntidad entidad = unidadAcademicaDAO.obtenerPorId(id);
            return convertidor.entidad_a_unidadAcademicaDTO(entidad);
        } catch (PersistenciaException e) {
            throw new Exception("Error al obtener la unidad académica: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene una lista de todas las unidades académicas.
     * @return Lista de UnidadAcademicaDTO con los datos de todas las unidades académicas.
     */
    @Override
    public List<UnidadAcademicaDTO> obtenerListaUnidadesAcademicas() {
        try {
            List<UnidadAcademicaEntidad> entidades = unidadAcademicaDAO.obtenerUnidadesAcademicas();
            return entidades.stream()
                    .map(convertidor::entidad_a_unidadAcademicaDTO)
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            System.err.println("Error al obtener la lista de unidades académicas: " + e.getMessage());
            return null;
        }
    }

    /**
     * Elimina una unidad académica por su ID.
     * @param id ID de la unidad académica a eliminar.
     * @throws Exception Si ocurre un error al eliminar la unidad.
     */
    @Override
    public void eliminarUnidadAcademica(Long id) throws Exception {
        try {
            unidadAcademicaDAO.eliminar(id);
        } catch (PersistenciaException e) {
            throw new Exception("Error al eliminar la unidad académica: " + e.getMessage(), e);
        }
    }
}
