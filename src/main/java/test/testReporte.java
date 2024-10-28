/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.PersistenciaException;
import persistencia.ReporteDAO;
import persistencia.interfaces.IReporteDAO;

/**
 *
 * @author Beto_
 */
public class testReporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Creamos la fabrica de entity manager (Es pesado y solo puede haber uno)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexionBD");
        
        //Creamos el entity Manager
        EntityManager em = emf.createEntityManager();
        
        IReporteDAO reporteDAO = new ReporteDAO(em);
        List<Long> idCarreras = new ArrayList();
        idCarreras.add(Long.valueOf("1"));
        
        try {
//            reporteDAO.reporteCentroComputo(LocalDate.of(2015, 11, 25), LocalDate.of(2025, 11, 25), idCarreras, Long.valueOf("1"));
//            reporteDAO.reporteCarreras(LocalDate.of(2024, 9, 25), LocalDate.of(2024, 11, 11), idCarreras);
            reporteDAO.reporteBloqueos(LocalDate.of(2024, 9, 16), LocalDate.of(2024, 11, 15));
        } catch (PersistenciaException ex) {
            Logger.getLogger(testReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
