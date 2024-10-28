package negocio;

import dto.ComputadoraDTO;
import entidad.ComputadoraEntidad;
import negocio.convertidores.ComputadoraCVR;
import negocio.exception.NegocioException;
import persistencia.ComputadoraDAO;
import persistencia.PersistenciaException;
import java.util.List;
import negocio.interfaces.IComputadoraNegocio;

public class ComputadoraNegocio implements IComputadoraNegocio {

    private ComputadoraDAO computadoraDAO;
    private ComputadoraCVR computadoraCVR;

    public ComputadoraNegocio(ComputadoraDAO computadoraDAO) { // Constructor sin cambios
        this.computadoraDAO = computadoraDAO;
        this.computadoraCVR = new ComputadoraCVR(); // Instancia de convertidor
    }

    @Override
    public ComputadoraDTO crearComputadora(ComputadoraDTO computadora, Long idLaboratorio) throws NegocioException {
        try {
            // Convertir DTO a entidad
            ComputadoraEntidad computadoraEntidad = computadoraCVR.computadoraDTO_entidad(computadora);
            // Guardar la nueva computadora en la base de datos
            computadoraDAO.guardar(computadora, idLaboratorio);
            // Convertir entidad de nuevo a DTO y devolver
            return computadoraCVR.entidad_computadoraDTO(computadoraEntidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al crear computadora: " + e.getMessage());
        }
    }

    @Override
    public ComputadoraDTO obtenerComputadora(Long id) throws NegocioException {
        try {
            ComputadoraEntidad computadoraEntidad = computadoraDAO.obtenerPorId(id);
            return computadoraCVR.entidad_computadoraDTO(computadoraEntidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener computadora: " + e.getMessage());
        }
    }

    @Override
    public List<ComputadoraDTO> obtenerListaComputadora() throws NegocioException {
        try {
            List<ComputadoraEntidad> computadoras = computadoraDAO.obtenerComputadoras();
            return computadoras.stream()
                    .map(computadoraCVR::entidad_computadoraDTO)
                    .toList();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener lista de computadoras: " + e.getMessage());
        }
    }

    @Override
    public void eliminarComputadora(Long id) throws NegocioException {
        try {
            computadoraDAO.eliminar(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar computadora: " + e.getMessage());
        }
    }

    @Override
    public void actualizarComputadora(ComputadoraDTO computadora) throws NegocioException {
        try {
            ComputadoraEntidad computadoraEntidad = computadoraCVR.computadoraDTO_entidad(computadora);
            computadoraDAO.actualizar(computadoraEntidad.getId(), computadora);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar computadora: " + e.getMessage());
        }
    }

    @Override
    public void cambiarEstatus(Long id, String nuevoEstatus) throws NegocioException {
        try {
            ComputadoraEntidad computadoraEntidad = computadoraDAO.obtenerPorId(id);
            computadoraEntidad.setEstatus(nuevoEstatus);
            computadoraDAO.actualizarEntidad(computadoraEntidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al cambiar el estatus de la computadora: " + e.getMessage());
        }
    }
}
