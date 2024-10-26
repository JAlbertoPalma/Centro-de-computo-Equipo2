/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidad.ApartadoEntidad;
import entidad.ComputadoraEntidad;
import entidad.EstudianteEntidad;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.IApartadoDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;

/**
 *
 * @author Beto_
 */
public class ApartadoDAO implements IApartadoDAO{
    @PersistenceContext
    private EntityManager entityManager;
    private IEstudianteDAO estudianteDAO = new EstudianteDAO(entityManager);
    private IComputadoraDAO computadoraDAO = new ComputadoraDAO(entityManager);


    public ApartadoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void apartar(Long id_estudiante, Long id_computadora) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();
            
            //Se busca el estudiante y la computadora
            EstudianteEntidad estudianteBuscado = estudianteDAO.obtenerPorId(id_estudiante);
            ComputadoraEntidad computadoraBuscada = computadoraDAO.obtenerPorId(id_computadora);

            ApartadoEntidad apartado = new ApartadoEntidad();
            apartado.setEstudiante(estudianteBuscado);
            apartado.setComputadora(computadoraBuscada);

            estudianteBuscado.getComputadoras().add(apartado);
            computadoraBuscada.getEstudiantes().add(apartado);
            computadoraBuscada.setEstatus(estudianteBuscado.getNombres() + " " +
                                          estudianteBuscado.getApellidoPaterno()+ " " +
                                          estudianteBuscado.getApellidoMaterno());

            estudianteDAO.actualizarEntidad(estudianteBuscado);
            computadoraDAO.actualizarEntidad(computadoraBuscada);
            entityManager.persist(apartado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("No se pudo guardar el apartado: " + e.getMessage());
        }
    }
    
    @Override
    public void desapartar(Long id) throws PersistenciaException{
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el apartado
            ApartadoEntidad apartadoBuscado = obtenerPorId(id);
            ComputadoraEntidad computadora = apartadoBuscado.getComputadora();
            EstudianteEntidad estudiante = apartadoBuscado.getEstudiante();
            
            //Calcular los minutos activo
            apartadoBuscado.setHoraFin(LocalTime.now());
            Duration duracion = Duration.between(apartadoBuscado.getHoraInicio(), apartadoBuscado.getHoraFin());
            apartadoBuscado.setSegundosActividad(duracion.getSeconds());
            
            //Actualizar los cambios
            computadora.setEstatus("Disponible");
            computadoraDAO.actualizarEntidad(computadora);
            estudianteDAO.actualizarEntidad(estudiante);
            actualizarEntidad(apartadoBuscado);
            
        }catch(Exception e){
            throw new PersistenciaException("No se pudo desapartar " + e.getMessage());
        }
    }
    
    @Override
    public void actualizarEntidad(ApartadoEntidad apartadoEntidad) throws PersistenciaException{
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(apartadoEntidad);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }

    @Override
    public ApartadoEntidad obtenerPorId(Long id) throws PersistenciaException {
        ApartadoEntidad apartadoBuscado = entityManager.find(ApartadoEntidad.class, id);
        if(apartadoBuscado == null){
                throw new PersistenciaException("No se encontró al apartado con el id");
            }
        return apartadoBuscado;
    }

    @Override
    public List<ApartadoEntidad> obtenerApartados() throws PersistenciaException {
        List<ApartadoEntidad> apartados = entityManager.createQuery("SELECT e FROM ApartadoEntidad e", ApartadoEntidad.class)
                .getResultList();
        if(apartados == null || apartados.isEmpty()){
            throw new PersistenciaException("No hay apartados por mostrar");
        }
        return apartados;
    }
    
}
