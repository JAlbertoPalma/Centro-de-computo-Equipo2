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
 *
 * @author Beto_
 */
public class UnidadAcademicaDAO implements IUnidadAcademicaDAO{
    @PersistenceContext
    private EntityManager entityManager;

    public UnidadAcademicaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void guardar(UnidadAcademicaDTO unidadAcademicaDTO) throws PersistenciaException {
        entityManager.getTransaction().begin();
        //buscar laboratorio de computo por id
        
        UnidadAcademicaEntidad unidadAcademica = new UnidadAcademicaEntidad(
                unidadAcademicaDTO.getNombre());
        entityManager.persist(unidadAcademica);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

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
            entityManager.getTransaction().commit();
            entityManager.close();
            }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

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
            entityManager.close();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public UnidadAcademicaEntidad obtenerPorId(Long id) throws PersistenciaException {
        UnidadAcademicaEntidad unidadAcademicaBuscada = entityManager.find(UnidadAcademicaEntidad.class, id);
        if(unidadAcademicaBuscada == null){
            throw new PersistenciaException("No se encontró al laboratorio de computo con el id");
        }
        return unidadAcademicaBuscada;
    }

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
