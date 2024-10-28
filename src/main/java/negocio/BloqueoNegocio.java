package negocio;

import dto.BloqueoDTO;
import negocio.convertidores.BloqueoCVR;
import negocio.interfaces.IBloqueoNegocio;
import persistencia.BloqueoDAO;
import persistencia.PersistenciaException;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class BloqueoNegocio implements IBloqueoNegocio {
    private BloqueoDAO bloqueoDAO;
    private BloqueoCVR bloqueoCVR;

    public BloqueoNegocio(EntityManager entityManager) {
        this.bloqueoDAO = new BloqueoDAO(entityManager);
        this.bloqueoCVR = new BloqueoCVR();
    }

    @Override
    public BloqueoDTO crearBloqueo(BloqueoDTO bloqueoDTO) throws Exception {
        try {
            bloqueoDAO.guardar(bloqueoDTO);
            return bloqueoDTO;
        } catch (PersistenciaException e) {
            throw new Exception("Error al crear bloqueo: " + e.getMessage());
        }
    }

    @Override
    public BloqueoDTO obtenerBloqueo(Long id) throws Exception {
        try {
            return bloqueoCVR.entidad_a_bloqueoDTO(bloqueoDAO.obtenerPorId(id));
        } catch (PersistenciaException e) {
            throw new Exception("Error al obtener bloqueo: " + e.getMessage());
        }
    }

    @Override
    public List<BloqueoDTO> obtenerListaBloqueos() {
        try {
            return bloqueoDAO.obtenerBloqueos().stream()
                    .map(bloqueoCVR::entidad_a_bloqueoDTO)
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            return List.of(); // o lanzar una excepción
        }
    }

    @Override
    public void eliminarBloqueo(Long id) throws Exception {
        try {
            bloqueoDAO.eliminar(id);
        } catch (PersistenciaException e) {
            throw new Exception("Error al eliminar bloqueo: " + e.getMessage());
        }
    }
}
