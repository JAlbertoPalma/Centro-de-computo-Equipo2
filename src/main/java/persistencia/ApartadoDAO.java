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
import persistencia.interfaces.IApartadoDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;

/**
 * Representa la Clase DAO que gestiona las
 * operaciones de los apartados en la base de datos
 * @author Beto_
 */
public class ApartadoDAO implements IApartadoDAO{
    private EntityManager entityManager;
    private IEstudianteDAO estudianteDAO;
    private IComputadoraDAO computadoraDAO;

    /**
     * Construye un apartadoDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public ApartadoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.estudianteDAO = new EstudianteDAO(entityManager);
        this.computadoraDAO = new ComputadoraDAO(entityManager);
    }
    
    /**
     * Realiza un apartado y asociación entre un estudiante y una computadora
     * @param id_estudiante el id del estudiante
     * @param id_computadora el id de la computadora
     * @throws PersistenciaException Si no se logra realizar el apartado
     */
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
            e.printStackTrace();
            throw new PersistenciaException("No se pudo guardar el apartado: " + e.getMessage());
        }
    }
    
    /**
     * Realiza un apartado, liberando la computadora y calculando los minutos de uso
     * @param id el id del apartado
     * @throws PersistenciaException Si no se logra desapartar
     */
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
            entityManager.getTransaction().commit();
            
        }catch(Exception e){
            throw new PersistenciaException("No se pudo desapartar " + e.getMessage());
        }
    }
    
    /**
     * Actualiza la entidad con un nuevo apartadoEntidad
     * @param apartadoEntidad el apartado con el cual actualizar
     * @throws PersistenciaException si no se logra actualizar
     */
    @Override
    public void actualizarEntidad(ApartadoEntidad apartadoEntidad) throws PersistenciaException{
        try{
            entityManager.merge(apartadoEntidad);
        }catch(Exception e){
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }
    
    /**
     * Obtiene un apartado por su id
     * @param id el id del apartado
     * @return el objeto entidad del apartado
     * @throws PersistenciaException si no se logra obtener por id
     */
    @Override
    public ApartadoEntidad obtenerPorId(Long id) throws PersistenciaException {
        ApartadoEntidad apartadoBuscado = entityManager.find(ApartadoEntidad.class, id);
        if(apartadoBuscado == null){
                throw new PersistenciaException("No se encontró al apartado con el id");
            }
        return apartadoBuscado;
    }
    
    /**
     * Enlista los objetos entidad del apartado
     * @return una lista tipo entidad del apartado
     * @throws PersistenciaException si la lista está vacía
     */
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
