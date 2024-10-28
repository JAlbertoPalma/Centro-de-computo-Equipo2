/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.LaboratorioComputoDTO;
import entidad.LaboratorioComputoEntidad;
import entidad.UnidadAcademicaEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import persistencia.interfaces.ILaboratorioComputoDAO;
import persistencia.interfaces.IUnidadAcademicaDAO;

/**
 * Representa la clase DAO que gestiona las operaciones
 * del laboratorio de computo en la base de datos
 * @author Beto_
 */
public class LaboratorioComputoDAO implements ILaboratorioComputoDAO{
    private EntityManager entityManager;
    private IUnidadAcademicaDAO unidadAcademicaDAO;
    
    /**
     * Construye un LaboratorioComputoDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public LaboratorioComputoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.unidadAcademicaDAO = new UnidadAcademicaDAO(entityManager);
    }
    
    /**
     * persiste un laboratorio de computo con DTO y una unidad academica asociada
     * @param laboratorioComputoDTO el DTO del laboratorio de computo
     * @param id_unidadAcademica el id de la unidad academica
     * @throws PersistenciaException si no se puede persistir
     */
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
            e.printStackTrace();
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza el laboratorio de computo con un DTO y su id
     * @param id el id del laboratorio de computo
     * @param laboratorioComputoDTO el DTO del laboratorio de computo
     * @throws PersistenciaException si no se puede actualizar
     */
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
    
    /**
     * Se elimina un laboratorio de computo por su id
     * @param id el id del laboratorio de computo
     * @throws PersistenciaException si no se puede eliminar
     */
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
    
    /**
     * Obtiene un laboratorio de computo entidad por su id
     * @param id el id del laboratorio de computo
     * @return el laboratorio de computo entidad
     * @throws PersistenciaException si no se logra obtener
     */
    @Override
    public LaboratorioComputoEntidad obtenerPorId(Long id) throws PersistenciaException {
        LaboratorioComputoEntidad laboratorioComputoBuscado = entityManager.find(LaboratorioComputoEntidad.class, id);
        if(laboratorioComputoBuscado == null){
            throw new PersistenciaException("No se encontró al laboratorio de computo con el id");
        }
        return laboratorioComputoBuscado;
    }
    
    /**+
     * Obtiene una lista de laboratorios de computo entidad
     * @return una lista de laboratorios de computo entidad
     * @throws PersistenciaException si la lista está vacía
     */
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
