/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidad.ApartadoEntidad;
import entidad.BloqueoEntidad;
import entidad.EstudianteBloqueoEntidad;
import entidad.EstudianteEntidad;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.IBloqueoDAO;
import persistencia.interfaces.IEstudianteBloqueoDAO;
import persistencia.interfaces.IEstudianteDAO;

/**
 *
 * @author Beto_
 */
public class EstudianteBloqueoDAO implements IEstudianteBloqueoDAO{
    @PersistenceContext
    private EntityManager entityManager;
    private IEstudianteDAO estudianteDAO = new EstudianteDAO(entityManager);
    private IBloqueoDAO bloqueoDAO = new BloqueoDAO(entityManager);

    public EstudianteBloqueoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void bloquear(Long id_estudiante, Long id_bloqueo) throws PersistenciaException {
        //Se inicial la transacción
        entityManager.getTransaction().begin();

        //Se busca el estudiante y la computadora
        EstudianteEntidad estudianteBuscado = estudianteDAO.obtenerPorId(id_estudiante);
        BloqueoEntidad bloqueoBuscado = bloqueoDAO.obtenerPorId(id_bloqueo);

        EstudianteBloqueoEntidad estudianteBloqueo = new EstudianteBloqueoEntidad();
        estudianteBloqueo.setEstudiante(estudianteBuscado);
        estudianteBloqueo.setBloqueo(bloqueoBuscado);

        estudianteBuscado.getBloqueos().add(estudianteBloqueo);
        bloqueoBuscado.getEstudiantes().add(estudianteBloqueo);
        estudianteBuscado.setEstaBloqueado(true);

        estudianteDAO.actualizarEntidad(estudianteBuscado);
        bloqueoDAO.actualizarEntidad(bloqueoBuscado);
        entityManager.persist(estudianteBloqueo);
        entityManager.getTransaction().commit();
    }

    @Override
    public void desbloquear(Long id) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el estudianteBloqueo
            EstudianteBloqueoEntidad estudianteBloqueoBuscado = obtenerPorId(id);
            EstudianteEntidad estudiante = estudianteBloqueoBuscado.getEstudiante();
            BloqueoEntidad bloqueo = estudianteBloqueoBuscado.getBloqueo();
            
            //Calcular los minutos activo
            estudianteBloqueoBuscado.setFechaFin(LocalDate.now());
            
            //Actualizar los cambios
            estudiante.setEstaBloqueado(false);
            estudianteDAO.actualizarEntidad(estudiante);
            bloqueoDAO.actualizarEntidad(bloqueo);
            actualizarEntidad(estudianteBloqueoBuscado);
            
        }catch(Exception e){
            throw new PersistenciaException("No se pudo desbloquear " + e.getMessage());
        }
    }

    @Override
    public void actualizarEntidad(EstudianteBloqueoEntidad estudianteBloqueoEntidad) throws PersistenciaException {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(estudianteBloqueoEntidad);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }

    @Override
    public EstudianteBloqueoEntidad obtenerPorId(Long id) throws PersistenciaException {
        EstudianteBloqueoEntidad estudianteBloqueoBuscado = entityManager.find(EstudianteBloqueoEntidad.class, id);
        if(estudianteBloqueoBuscado == null){
                throw new PersistenciaException("No se encontró al apartado con el id");
            }
        return estudianteBloqueoBuscado;
    }

    @Override
    public List<EstudianteBloqueoEntidad> obtenerApartados() throws PersistenciaException {
        List<EstudianteBloqueoEntidad> estudiantesBloqueos = entityManager.createQuery("SELECT e FROM EstudianteBloqueoEntidad e", EstudianteBloqueoEntidad.class)
                .getResultList();
        if(estudiantesBloqueos == null || estudiantesBloqueos.isEmpty()){
            throw new PersistenciaException("No hay apartados por mostrar");
        }
        return estudiantesBloqueos;
    }
    
}
