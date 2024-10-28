package negocio;

import dto.CarreraDTO;
import entidad.CarreraEntidad;
import negocio.convertidores.CarreraCVR;
import negocio.exception.NegocioException;
import persistencia.CarreraDAO;
import persistencia.interfaces.ICarreraDAO;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import negocio.interfaces.ICarreraNegocio;

/**
 * Clase que gestiona la lógica de negocio para las carreras.
 * 
 * @author Brandon Valenzuela
 */
public class CarreraNegocio implements ICarreraNegocio {
    private ICarreraDAO carreraDAO;
    private CarreraCVR carreraCVR;

    /**
     * Constructor de la clase CarreraNegocio.
     * 
     * @param entityManager el EntityManager para las operaciones de la base de datos
     */
    public CarreraNegocio(EntityManager entityManager) {
        this.carreraDAO = new CarreraDAO(entityManager);
        this.carreraCVR = new CarreraCVR();
    }

    /**
     * Crea una nueva carrera.
     * 
     * @param carreraDTO el DTO de la carrera a crear
     * @return el DTO de la carrera creada
     * @throws NegocioException si ocurre un error al crear la carrera
     */
    @Override
    public CarreraDTO crearCarrera(CarreraDTO carreraDTO) throws NegocioException {
        try {
            carreraDAO.guardar(carreraDTO);
            return carreraDTO;
        } catch (Exception e) {
            throw new NegocioException("Error al crear la carrera: " + e.getMessage());
        }
    }

    /**
     * Obtiene una carrera por su ID.
     * 
     * @param id el ID de la carrera a obtener
     * @return el DTO de la carrera obtenida
     * @throws NegocioException si ocurre un error al obtener la carrera
     */
    @Override
    public CarreraDTO obtenerCarrera(Long id) throws NegocioException {
        try {
            CarreraEntidad carreraEntidad = carreraDAO.obtenerPorId(id);
            return carreraCVR.entidad_carreraDTO(carreraEntidad);
        } catch (Exception e) {
            throw new NegocioException("Error al obtener la carrera: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de todas las carreras.
     * 
     * @return una lista de DTOs de carreras
     */
    @Override
    public List<CarreraDTO> obtenerListaCarreras() {
        try {
            List<CarreraEntidad> carrerasEntidad = carreraDAO.obtenerCarreras();
            List<CarreraDTO> carrerasDTO = new ArrayList<>();
            for (CarreraEntidad carrera : carrerasEntidad) {
                carrerasDTO.add(carreraCVR.entidad_carreraDTO(carrera));
            }
            return carrerasDTO;
        } catch (Exception e) {
            // Manejo de excepciones (por ejemplo, registrar el error)
            return new ArrayList<>(); // Retornar lista vacía si ocurre un error
        }
    }

    /**
     * Elimina una carrera por su ID.
     * 
     * @param id el ID de la carrera a eliminar
     * @throws NegocioException si ocurre un error al eliminar la carrera
     */
    @Override
    public void eliminarCarrera(Long id) throws NegocioException {
        try {
            carreraDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar la carrera: " + e.getMessage());
        }
    }
}
