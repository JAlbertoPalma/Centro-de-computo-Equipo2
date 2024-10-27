/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.ComputadoraDTO;
import entidad.ComputadoraEntidad;
import entidad.LaboratorioComputoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.ILaboratorioComputoDAO;

/**
 * Representa la clase DAO que gestiona las operaciones
 * de la computadora en la base de datos
 * @author Beto_
 */
public class ComputadoraDAO implements IComputadoraDAO{
    @PersistenceContext
    private EntityManager entityManager;
    ILaboratorioComputoDAO laboratorioComputoDAO;
    
    /**
     * Construye una ComputadoraDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public ComputadoraDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.laboratorioComputoDAO = new LaboratorioComputoDAO(entityManager);
    }
    
    /**
     * Persiste una computadora asociada a un laboratorio de computo
     * @param computadoraDTO el DTO de la computadora
     * @param id_laboratorioComputo el id del laboratorio de computo
     * @throws PersistenciaException si no se logra guardar
     */
    @Override
    public void guardar(ComputadoraDTO computadoraDTO, Long id_laboratorioComputo) throws PersistenciaException {
        try{
            entityManager.getTransaction().begin();
            
            //buscar laboratorio de computo por id
            LaboratorioComputoEntidad laboratorioComputoBuscado = laboratorioComputoDAO.obtenerPorId(id_laboratorioComputo);

            ComputadoraEntidad computadora = new ComputadoraEntidad(
                    computadoraDTO.getContrasenaMaestra(),
                    computadoraDTO.getDireccionIP(),
                    computadoraDTO.getNoMaquina(),
                    computadoraDTO.getTipo(),
                    laboratorioComputoBuscado);
            
            //Agregar la computadora a la lista del laboratorio
            laboratorioComputoBuscado.getComputadoras().add(computadora);
            
            entityManager.persist(computadora);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    /**
     * Actualiza una computadora con un DTO y su id
     * @param id el id de la computadora
     * @param computadoraDTO el DTO de la computadora
     * @throws PersistenciaException si no se puede actualizar
     */
    @Override
    public void actualizar(Long id, ComputadoraDTO computadoraDTO) throws PersistenciaException {
        try{ 
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la computadora a actualizar
            ComputadoraEntidad computadoraBuscada = obtenerPorId(id);

            //Se actualizan los valores de la computadora
            computadoraBuscada.setContrasenaMaestra(computadoraDTO.getContrasenaMaestra());
            computadoraBuscada.setDireccionIP(computadoraDTO.getDireccionIP());
            computadoraBuscada.setNoMaquina(computadoraDTO.getNoMaquina());
            computadoraBuscada.setTipo(computadoraDTO.getTipo());
            computadoraBuscada.setEstatus(computadoraDTO.getEstatus());

            entityManager.merge(computadoraBuscada);
            entityManager.getTransaction().commit();
            }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    /**
     * Actualiza la entidad con otra entidad
     * @param computadoraEntidad la computadora entidad 
     * @throws PersistenciaException si no se puede actualizar la entidad
     */
    @Override
    public void actualizarEntidad(ComputadoraEntidad computadoraEntidad) throws PersistenciaException{
        try{
            entityManager.merge(computadoraEntidad);
        }catch(Exception e){
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }
    
    /**
     * Elimina una computadora con su id
     * @param id el id de la computadora
     * @throws PersistenciaException si no se puede eliminar
     */
    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca la computadora a eliminar
            ComputadoraEntidad computadoraBuscada = obtenerPorId(id);
            
            //Elimina el estudiante y termina la transacción
            entityManager.remove(computadoraBuscada);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene la computadora entidad por su id
     * @param id el id de la computadora
     * @return una computadora entidad
     * @throws PersistenciaException si no se logra obtener
     */
    @Override
    public ComputadoraEntidad obtenerPorId(Long id) throws PersistenciaException {
        ComputadoraEntidad computadoraBuscada = entityManager.find(ComputadoraEntidad.class, id);
        if(computadoraBuscada == null){
                throw new PersistenciaException("No se encontró al estudiante con el id");
            }
        return computadoraBuscada;
    }

    /**
     * Obtiene una lista de computadoras entidad
     * @return la lista de computadoras entidad
     * @throws PersistenciaException si la lista está vacía
     */
    @Override
    public List<ComputadoraEntidad> obtenerComputadoras() throws PersistenciaException {
        List<ComputadoraEntidad> computadoras = entityManager.createQuery("SELECT e FROM ComputadoraEntidad e", ComputadoraEntidad.class)
                .getResultList();
        if(computadoras == null || computadoras.isEmpty()){
            throw new PersistenciaException("No hay computadoras por mostrar");
        }
        return computadoras;
    }
    
}
