/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.ComputadoraDTO;
import dto.EstudianteDTO;
import entidad.ComputadoraEntidad;
import entidad.EstudianteEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.IComputadoraDAO;

/**
 *
 * @author Beto_
 */
public class ComputadoraDAO implements IComputadoraDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(ComputadoraDTO computadoraDTO, Long id_laboratorioComputo) throws PersistenciaException {
        try{
            entityManager.getTransaction().begin();
            //buscar laboratorio de computo por id

            ComputadoraEntidad computadora = new ComputadoraEntidad(
                    computadoraDTO.getContrasenaMaestra(),
                    computadoraDTO.getDireccionIP(),
                    computadoraDTO.getNoMaquina(),
                    computadoraDTO.getTipo(),
                    computadoraDTO.getEstatus(),
                    laboratorioComputoBuscado);
            entityManager.persist(computadora);
            entityManager.getTransaction().commit();
            entityManager.close();
            }catch(Exception e){
                throw new PersistenciaException("Error: " + e.getMessage());
            }
    }

    @Override
    public void actualizar(Long id, ComputadoraDTO computadoraDTO) throws PersistenciaException {
        try{ 
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el estudiante a actualizar
            ComputadoraEntidad computadoraBuscada = obtenerPorId(id);

            //Se actualizan los valores de la computadora
            computadoraBuscada.setContrasenaMaestra(computadoraDTO.getContrasenaMaestra());
            computadoraBuscada.setContrasenaMaestra(computadoraDTO.getDireccionIP());
            computadoraBuscada.setNoMaquina(computadoraDTO.getNoMaquina());
            computadoraBuscada.setTipo(computadoraDTO.getTipo());
            computadoraBuscada.setEstatus(computadoraDTO.getEstatus());

            entityManager.merge(computadoraBuscada);
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
            ComputadoraEntidad computadoraBuscada = obtenerPorId(id);
            
            //Elimina el estudiante y termina la transacción
            entityManager.remove(computadoraBuscada);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public ComputadoraEntidad obtenerPorId(Long id) throws PersistenciaException {
        ComputadoraEntidad computadoraBuscada = entityManager.find(ComputadoraEntidad.class, id);
        if(computadoraBuscada == null){
                throw new PersistenciaException("No se encontró al estudiante con el id");
            }
        return computadoraBuscada;
    }

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
