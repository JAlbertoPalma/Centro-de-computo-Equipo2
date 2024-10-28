package negocio;

import dto.SoftwareInstaladoDTO;
import entidad.SoftwareInstaladoEntidad;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import negocio.convertidores.SoftwareInstaladoCVR;
import negocio.exception.NegocioException;
import negocio.interfaces.ISoftwareInstaladoNegocio;

public class SoftwareInstaladoNegocio implements ISoftwareInstaladoNegocio {

    private final EntityManagerFactory entityManagerFactory;
    private final SoftwareInstaladoCVR convertidor;

    public SoftwareInstaladoNegocio() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
        this.convertidor = new SoftwareInstaladoCVR();
    }

    @Override
    public SoftwareInstaladoDTO crearSoftware(SoftwareInstaladoDTO software) throws NegocioException {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SoftwareInstaladoEntidad softwareEntidad = convertidor.softwareDTO_entidad(software);
            em.persist(softwareEntidad);
            tx.commit();
            return convertidor.entidad_softwareDTO(softwareEntidad);
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new NegocioException("Error al crear el software: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public SoftwareInstaladoDTO obtenerSoftware(Long id) throws NegocioException {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            SoftwareInstaladoEntidad softwareEntidad = em.find(SoftwareInstaladoEntidad.class, id);
            if (softwareEntidad == null) {
                throw new NegocioException("Software con ID " + id + " no encontrado.");
            }
            return convertidor.entidad_softwareDTO(softwareEntidad);
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el software: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<SoftwareInstaladoDTO> obtenerListaSoftware() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            List<SoftwareInstaladoEntidad> entidades = em.createQuery("SELECT s FROM SoftwareInstaladoEntidad s", SoftwareInstaladoEntidad.class)
                                                        .getResultList();
            return entidades.stream()
                            .map(convertidor::entidad_softwareDTO)
                            .collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarSoftware(Long id) throws NegocioException {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SoftwareInstaladoEntidad softwareEntidad = em.find(SoftwareInstaladoEntidad.class, id);
            if (softwareEntidad == null) {
                throw new NegocioException("Software con ID " + id + " no encontrado.");
            }
            em.remove(softwareEntidad);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new NegocioException("Error al eliminar el software: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
