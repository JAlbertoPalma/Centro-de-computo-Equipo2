/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import dto.CarreraDTO;
import dto.EstudianteDTO;
import entidad.CarreraEntidad;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.CarreraDAO;
import persistencia.ComputadoraDAO;
import persistencia.EstudianteDAO;
import persistencia.LaboratorioComputoDAO;
import persistencia.PersistenciaException;
import persistencia.interfaces.ICarreraDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;
import persistencia.interfaces.ILaboratorioComputoDAO;

/**
 *
 * @author Beto_
 */
public class testPersistencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Creamos la fabrica de entity manager (Es pesado y solo puede haber uno)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexionBD");
        
        //Creamos el entity Manager
        EntityManager em = emf.createEntityManager();
        
        ICarreraDAO carreraDAO = new CarreraDAO(em);
        IEstudianteDAO estudianteDAO = new EstudianteDAO(em);
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(em);
        ILaboratorioComputoDAO laboratorioComputoDAO = new LaboratorioComputoDAO(em);
        
//        try {
//            carreraDAO.guardar(new CarreraDTO("Ing industrial", LocalTime.of(0, 5, 0)));
//            CarreraEntidad carreraA = carreraDAO.obtenerPorId(Long.valueOf("1")); 
//            System.out.println("Tiempo: " + carreraA.getTiempoLimite().getMinute());
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            estudianteDAO.guardar(new EstudianteDTO("Julian", "Cazares", "Patino", "abc123"), Long.valueOf("1"));
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            co
        } catch (PersistenciaException ex) {
            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
