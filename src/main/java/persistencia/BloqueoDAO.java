/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.BloqueoDTO;
import entidad.BloqueoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import persistencia.interfaces.IBloqueoDAO;

/**
 * Representa la clase DAO que gestiona las operaciones
 * del objeto Bloqueo en la base de datos
 * @author Beto_
 */
public class BloqueoDAO implements IBloqueoDAO{
    private EntityManager entityManager;

    /**
     * Construye un BloqueoDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public BloqueoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Crea un nuevo objeto bloqueo apartir de un DTO
     * @param bloqueoDTO el bloqueoDTO a extraer datos
     * @throws PersistenciaException  Si no se puede guardar
     */
    @Override
    public void guardar(BloqueoDTO bloqueoDTO) throws PersistenciaException {
        try{
        entityManager.getTransaction().begin();
        
        BloqueoEntidad bloqueo = new BloqueoEntidad(
                bloqueoDTO.getMotivo());
        
        entityManager.persist(bloqueo);
        entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza un bloqueo con los datos del DTO buscando por su id
     * @param id el id el bloqueo
     * @param bloqueoDTO el BloqueoDTO a extraer datos
     * @throws PersistenciaException Si no se puede actualizar
     */
    @Override
    public void actualizar(Long id, BloqueoDTO bloqueoDTO) throws PersistenciaException {
        try{ 
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la carrera a actualizar
            BloqueoEntidad bloqueoBuscado = obtenerPorId(id);

            //Se actualizan los valores de la carrera
            bloqueoBuscado.setMotivo(bloqueoDTO.getMotivo());

            entityManager.merge(bloqueoBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
                throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza la entidad con otra entidad
     * @param bloqueoEntidad la nueva entidad bloqueo
     * @throws PersistenciaException Si no se puede actualizar la entidad de bloqueo
     */
    @Override
    public void actualizarEntidad(BloqueoEntidad bloqueoEntidad) throws PersistenciaException{
        try{
            entityManager.merge(bloqueoEntidad);
        }catch(Exception e){
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }
    
    /**
     * Elimina un bloqueo por su id
     * @param id el id del bloqueo
     * @throws PersistenciaException Si no se puede eliminar
     */
    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la computadora a eliminar
            BloqueoEntidad bloqueoBuscado = obtenerPorId(id);
            
            //Elimina el bloqueo y termina la transacción
            entityManager.remove(bloqueoBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    /**
     * Obtiene un bloqueo por su id
     * @param id el id del bloqueo
     * @return La entidad bloqueo
     * @throws PersistenciaException si no se obtiene el bloqueo
     */
    @Override
    public BloqueoEntidad obtenerPorId(Long id) throws PersistenciaException {
        BloqueoEntidad bloqueoEntidad = entityManager.find(BloqueoEntidad.class, id);
        if(bloqueoEntidad == null){
            throw new PersistenciaException("No se encontró el bloqueo con este id");
        }
        return bloqueoEntidad;
    }

    /**
     * obtiene una lista de bloqueos entidad
     * @return la lista de bloqueos entidad
     * @throws PersistenciaException si la lista está vacía
     */
    @Override
    public List<BloqueoEntidad> obtenerBloqueos() throws PersistenciaException {
        List<BloqueoEntidad> bloqueos = entityManager.createQuery("SELECT e FROM BloqueoEntidad e", BloqueoEntidad.class)
                .getResultList();
        if(bloqueos == null || bloqueos.isEmpty()){
            throw new PersistenciaException("No hay bloqueos por mostrar");
        }
        return bloqueos;
    }
}
