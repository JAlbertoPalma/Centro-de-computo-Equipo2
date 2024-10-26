/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.CarreraDTO;
import entidad.CarreraEntidad;
import entidad.ComputadoraEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.ICarreraDAO;

/**
 *
 * @author Beto_
 */
public class CarreraDAO implements ICarreraDAO{
    private EntityManager entityManager;

    public CarreraDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void guardar(CarreraDTO carreraDTO) throws PersistenciaException {
        try{
        entityManager.getTransaction().begin();
        
        CarreraEntidad carrera = new CarreraEntidad(
                carreraDTO.getNombre(),
                carreraDTO.getTiempoLimite());
        entityManager.persist(carrera);
        entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Long id, CarreraDTO carreraDTO) throws PersistenciaException {
        try{ 
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la carrera a actualizar
            CarreraEntidad carreraBuscada = obtenerPorId(id);

            //Se actualizan los valores de la carrera
            carreraBuscada.setNombre(carreraDTO.getNombre());
            carreraBuscada.setTiempoLimite(carreraDTO.getTiempoLimite());

            entityManager.merge(carreraBuscada);
            entityManager.getTransaction().commit();
            }catch(Exception e){
                throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la carrera a eliminar
            CarreraEntidad carreraBuscada = obtenerPorId(id);
            
            //Elimina la carrera y termina la transacción
            entityManager.remove(carreraBuscada);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public CarreraEntidad obtenerPorId(Long id) throws PersistenciaException {
        CarreraEntidad carreraBuscada = entityManager.find(CarreraEntidad.class, id);
        if(carreraBuscada == null){
            throw new PersistenciaException("No se encontró la carrera con este id");
        }
        return carreraBuscada;
    }

    @Override
    public List<CarreraEntidad> obtenerCarreras() throws PersistenciaException {
        List<CarreraEntidad> carreras = entityManager.createQuery("SELECT e FROM CarreraEntidad e", CarreraEntidad.class)
                .getResultList();
        if(carreras == null || carreras.isEmpty()){
            throw new PersistenciaException("No hay carreras por mostrar");
        }
        return carreras;
    }
    
}
