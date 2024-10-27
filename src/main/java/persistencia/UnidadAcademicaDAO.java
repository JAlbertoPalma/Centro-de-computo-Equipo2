/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.UnidadAcademicaDTO;
import entidad.LaboratorioComputoEntidad;
import entidad.UnidadAcademicaEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.IUnidadAcademicaDAO;

/**
 * Representa la clase DAO que gestiona las operaciones
 * de la unidadAcademica en la base de datos
 * @author Beto_
 */
public class UnidadAcademicaDAO implements IUnidadAcademicaDAO{
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Construye una UnidadAcademicaDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public UnidadAcademicaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * persiste una unidad academica con un DTO
     * @param unidadAcademicaDTO el DTO de la unidad academica
     * @throws PersistenciaException si no se puede persistir
     */
    @Override
    public void guardar(UnidadAcademicaDTO unidadAcademicaDTO) throws PersistenciaException {
        entityManager.getTransaction().begin();
        
        UnidadAcademicaEntidad unidadAcademica = new UnidadAcademicaEntidad(
                unidadAcademicaDTO.getNombre());
        entityManager.persist(unidadAcademica);
        entityManager.getTransaction().commit();
    }
    
    /**
     * actualiza la unidad academica con un DTO y su id
     * @param id el id de la unidad academica
     * @param unidadAcademicaDTO el DTO de la unidad academica
     * @throws PersistenciaException si no se puede actualizar
     */
    @Override
    public void actualizar(Long id, UnidadAcademicaDTO unidadAcademicaDTO) throws PersistenciaException {
        try{ 
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la unidad a actualizar
            UnidadAcademicaEntidad unidadAcademicaBuscada = obtenerPorId(id);

            //Se actualizan los valores de la unidad
            unidadAcademicaBuscada.setNombre(unidadAcademicaDTO.getNombre());

            entityManager.merge(unidadAcademicaBuscada);
            entityManager.getTransaction().commit();;
            }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    /**
     * elimina una unidad academica por su id
     * @param id el id de la unidad academica
     * @throws PersistenciaException si no se puede eliminar
     */
    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la computadora a eliminar
            UnidadAcademicaEntidad unidadAcademicaBuscada = obtenerPorId(id);
            
            //Elimina el estudiante y termina la transacción
            entityManager.remove(unidadAcademicaBuscada);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    /**
     * obtiene una unidadAcademica por su id
     * @param id el id de la unidad academica
     * @return una unidad academica entidad
     * @throws PersistenciaException si no se logra obtener
     */
    @Override
    public UnidadAcademicaEntidad obtenerPorId(Long id) throws PersistenciaException {
        UnidadAcademicaEntidad unidadAcademicaBuscada = entityManager.find(UnidadAcademicaEntidad.class, id);
        if(unidadAcademicaBuscada == null){
            throw new PersistenciaException("No se encontró al laboratorio de computo con el id");
        }
        return unidadAcademicaBuscada;
    }
    
    /**
     * Obtiene una lista de unidades academicas entidad
     * @return una lista de unidades academicas entidad
     * @throws PersistenciaException si la lista está vacía
     */
    @Override
    public List<UnidadAcademicaEntidad> obtenerUnidadesAcademicas() throws PersistenciaException {
        List<UnidadAcademicaEntidad> unidadesAcademicas = entityManager.createQuery("SELECT e FROM LaboratorioComputoEntidad e", UnidadAcademicaEntidad.class)
                .getResultList();
        if(unidadesAcademicas == null || unidadesAcademicas.isEmpty()){
            throw new PersistenciaException("No hay laboratorios de computo por mostrar");
        }
        return unidadesAcademicas;
    }
    
}
