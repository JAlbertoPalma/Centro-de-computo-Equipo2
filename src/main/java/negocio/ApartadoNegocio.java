package negocio;

import dto.ApartadoDTO;
import entidad.ApartadoEntidad;
import negocio.convertidores.ApartadoCVR;
import persistencia.ApartadoDAO;
import persistencia.PersistenciaException;
import java.util.List;

/**
 * Clase que gestiona la lógica de negocio para los apartados.
 * Utiliza ApartadoDAO para realizar las operaciones CRUD.
 * 
 * @author Brandon Valenzuela
 */
public class ApartadoNegocio {
    private ApartadoDAO apartadoDAO;
    private ApartadoCVR apartadoCVR;

    /**
     * Constructor que inicializa el ApartadoDAO y el convertidor.
     * 
     * @param apartadoDAO el DAO de apartado
     */
    public ApartadoNegocio(ApartadoDAO apartadoDAO) {
        if (apartadoDAO == null) {
            throw new IllegalArgumentException("El ApartadoDAO no puede ser nulo.");
        }
        this.apartadoDAO = apartadoDAO;
        this.apartadoCVR = new ApartadoCVR();
    }

    /**
     * Aparta una computadora para un estudiante.
     * 
     * @param idEstudiante el id del estudiante
     * @param idComputadora el id de la computadora
     * @throws PersistenciaException si no se logra realizar el apartado
     * @throws IllegalArgumentException si los ids son nulos o negativos
     */
    public void apartar(Long idEstudiante, Long idComputadora) throws PersistenciaException {
        validarId(idEstudiante, "idEstudiante");
        validarId(idComputadora, "idComputadora");
        
        apartadoDAO.apartar(idEstudiante, idComputadora);
    }

    /**
     * Desaparta una computadora.
     * 
     * @param id el id del apartado
     * @throws PersistenciaException si no se logra desapartar
     * @throws IllegalArgumentException si el id es nulo o negativo
     */
    public void desapartar(Long id) throws PersistenciaException {
        validarId(id, "id");
        
        apartadoDAO.desapartar(id);
    }

    /**
     * Actualiza un apartado existente.
     * 
     * @param apartadoDTO el DTO que contiene los datos a actualizar
     * @throws PersistenciaException si no se logra actualizar
     * @throws IllegalArgumentException si el DTO es nulo
     */
    public void actualizarApartado(ApartadoDTO apartadoDTO) throws PersistenciaException {
        if (apartadoDTO == null) {
            throw new IllegalArgumentException("El ApartadoDTO no puede ser nulo.");
        }

        ApartadoEntidad apartadoEntidad = apartadoCVR.apartadoDTO_entidad(apartadoDTO);
        apartadoDAO.actualizarEntidad(apartadoEntidad);
    }

    /**
     * Obtiene un apartado por su id.
     * 
     * @param id el id del apartado
     * @return el DTO del apartado
     * @throws PersistenciaException si no se logra obtener por id
     * @throws IllegalArgumentException si el id es nulo o negativo
     */
    public ApartadoDTO obtenerApartadoPorId(Long id) throws PersistenciaException {
        validarId(id, "id");
        
        ApartadoEntidad apartadoEntidad = apartadoDAO.obtenerPorId(id);
        return apartadoCVR.entidad_apartadoDTO(apartadoEntidad);
    }

    /**
     * Obtiene todos los apartados.
     * 
     * @return una lista de DTOs de apartados
     * @throws PersistenciaException si no se logra obtener la lista
     */
    public List<ApartadoDTO> obtenerApartados() throws PersistenciaException {
        List<ApartadoEntidad> apartados = apartadoDAO.obtenerApartados();
        return apartados.stream()
                .map(apartadoCVR::entidad_apartadoDTO)
                .toList();
    }

    /**
     * Método privado para validar que el id no sea nulo o negativo.
     * 
     * @param id el id a validar
     * @param nombre el nombre del parámetro para la excepción
     * @throws IllegalArgumentException si el id es nulo o negativo
     */
    private void validarId(Long id, String nombre) {
        if (id == null) {
            throw new IllegalArgumentException("El " + nombre + " no puede ser nulo.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("El " + nombre + " no puede ser negativo.");
        }
    }
}
