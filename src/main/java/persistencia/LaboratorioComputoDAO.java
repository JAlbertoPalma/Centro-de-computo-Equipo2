/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.LaboratorioComputoDTO;
import entidad.CarreraEntidad;
import entidad.ComputadoraEntidad;
import entidad.LaboratorioComputoEntidad;
import entidad.UnidadAcademicaEntidad;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.ILaboratorioComputoDAO;
import persistencia.interfaces.IUnidadAcademicaDAO;

/**
 *
 * @author Beto_
 */
public class LaboratorioComputoDAO implements ILaboratorioComputoDAO{
    @PersistenceContext
    private EntityManager entityManager;
    private IUnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO(entityManager);

    public LaboratorioComputoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void guardar(LaboratorioComputoDTO laboratorioComputoDTO, Long id_unidadAcademica) throws PersistenciaException {
        try{ 
        entityManager.getTransaction().begin();
        
        //buscar unidadAcademica por id
        UnidadAcademicaEntidad unidadAcademicaBuscada = unidadAcademicaDAO.obtenerPorId(id_unidadAcademica);
        
        LaboratorioComputoEntidad laboratorioComputo = new LaboratorioComputoEntidad(
                laboratorioComputoDTO.getNombre(),
                laboratorioComputoDTO.getHoraInicio(),
                laboratorioComputoDTO.getHoraFin(),
                unidadAcademicaBuscada);
        
        //Agregar el laboratorio a la lista de la unidad academica
        unidadAcademicaBuscada.getLaboratoriosComputo().add(laboratorioComputo);
        
        entityManager.persist(laboratorioComputo);
        entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Long id, LaboratorioComputoDTO laboratorioComputoDTO) throws PersistenciaException {
        try{ 
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el laboratorio a actualizar
            LaboratorioComputoEntidad laboratorioComputoBuscado = obtenerPorId(id);

            //Se actualizan los valores del laboratorio
            laboratorioComputoBuscado.setNombre(laboratorioComputoDTO.getNombre());
            laboratorioComputoBuscado.setHoraInicio(laboratorioComputoDTO.getHoraInicio());
            laboratorioComputoBuscado.setHoraInicio(laboratorioComputoDTO.getHoraFin());

            entityManager.merge(laboratorioComputoBuscado);
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

            //Se busca la computadora a eliminar
            LaboratorioComputoEntidad laboratorioComputoBuscado = obtenerPorId(id);
            
            //Elimina el estudiante y termina la transacción
            entityManager.remove(laboratorioComputoBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public LaboratorioComputoEntidad obtenerPorId(Long id) throws PersistenciaException {
        LaboratorioComputoEntidad laboratorioComputoBuscado = entityManager.find(LaboratorioComputoEntidad.class, id);
        if(laboratorioComputoBuscado == null){
            throw new PersistenciaException("No se encontró al laboratorio de computo con el id");
        }
        return laboratorioComputoBuscado;
    }

    @Override
    public List<LaboratorioComputoEntidad> obtenerLaboratoriosComputo() throws PersistenciaException {
        List<LaboratorioComputoEntidad> laboratoriosComputo = entityManager.createQuery("SELECT e FROM LaboratorioComputoEntidad e", LaboratorioComputoEntidad.class)
                .getResultList();
        if(laboratoriosComputo == null || laboratoriosComputo.isEmpty()){
            throw new PersistenciaException("No hay laboratorios de computo por mostrar");
        }
        return laboratoriosComputo;
    }
    
}
