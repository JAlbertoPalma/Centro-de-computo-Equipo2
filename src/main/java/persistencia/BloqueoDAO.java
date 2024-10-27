/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.BloqueoDTO;
import entidad.BloqueoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.IBloqueoDAO;

/**
 *
 * @author Beto_
 */
public class BloqueoDAO implements IBloqueoDAO{
    @PersistenceContext
    private EntityManager entityManager;


    public BloqueoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
    
    @Override
    public void actualizarEntidad(BloqueoEntidad bloqueoEntidad) throws PersistenciaException{
        try{
            entityManager.merge(bloqueoEntidad);
        }catch(Exception e){
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }

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

    @Override
    public BloqueoEntidad obtenerPorId(Long id) throws PersistenciaException {
        BloqueoEntidad bloqueoEntidad = entityManager.find(BloqueoEntidad.class, id);
        if(bloqueoEntidad == null){
            throw new PersistenciaException("No se encontró el bloqueo con este id");
        }
        return bloqueoEntidad;
    }

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
