/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.LaboratorioComputoDTO;
import entidad.CarreraEntidad;
import entidad.LaboratorioComputoEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.ILaboratorioComputoDAO;

/**
 *
 * @author Beto_
 */
public class LaboratorioComputoDAO implements ILaboratorioComputoDAO{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void guardar(LaboratorioComputoDTO laboratorioComputoDTO) throws PersistenciaException {
        entityManager.getTransaction().begin();
        
        LaboratorioComputoEntidad laboratorioComputo = new LaboratorioComputoEntidad(
                laboratorioComputoDTO.getNombre(),
                laboratorioComputoDTO.getHoraInicio(),
                laboratorioComputoDTO.getHoraFin());
        entityManager.persist(carrera);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void actualizar(Long id, LaboratorioComputoDTO laboratorioDTO) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LaboratorioComputoEntidad obtenerPorId(Long id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
