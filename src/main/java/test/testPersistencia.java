/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import dto.BloqueoDTO;
import dto.CarreraDTO;
import dto.ComputadoraDTO;
import dto.EstudianteDTO;
import dto.LaboratorioComputoDTO;
import dto.UnidadAcademicaDTO;
import entidad.CarreraEntidad;
import entidad.ComputadoraEntidad;
import entidad.EstudianteEntidad;
import enums.TipoComputadora;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.ApartadoDAO;
import persistencia.BloqueoDAO;
import persistencia.CarreraDAO;
import persistencia.ComputadoraDAO;
import persistencia.EstudianteBloqueoDAO;
import persistencia.EstudianteDAO;
import persistencia.LaboratorioComputoDAO;
import persistencia.PersistenciaException;
import persistencia.UnidadAcademicaDAO;
import persistencia.interfaces.IApartadoDAO;
import persistencia.interfaces.IBloqueoDAO;
import persistencia.interfaces.ICarreraDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;
import persistencia.interfaces.ILaboratorioComputoDAO;
import persistencia.interfaces.IUnidadAcademicaDAO;

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
        IUnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO(em);
        ILaboratorioComputoDAO laboratorioComputoDAO = new LaboratorioComputoDAO(em);
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(em);
        IApartadoDAO apartadoDAO = new ApartadoDAO(em);
        IBloqueoDAO bloqueoDAO = new BloqueoDAO(em);
        EstudianteBloqueoDAO estudianteBloqueoDAO = new EstudianteBloqueoDAO(em);

        //Guarda: correcto
//        try {
//            carreraDAO.guardar(new CarreraDTO("Ing industrial", LocalTime.of(0, 5, 0)));
//            estudianteDAO.guardar(new EstudianteDTO("Julian", "Cazares", "Patino", "abc123"), Long.valueOf("1"));
//            estudianteDAO.guardar(new EstudianteDTO("Zendaya", "Castro", "Lopez", "abc456"), Long.valueOf("1"));
//            estudianteDAO.guardar(new EstudianteDTO("Galo", "Sierra", "Montes", "abc789"), Long.valueOf("1"));
//            unidadAcademicaDAO.guardar(new UnidadAcademicaDTO("ITSON CENTRO"));
//            laboratorioComputoDAO.guardar(new LaboratorioComputoDTO("cisco", LocalTime.of(0, 30), LocalTime.of(17, 30)), Long.valueOf("1"));
//            computadoraDAO.guardar(new ComputadoraDTO("abc12", "199.555.33", 1, TipoComputadora.TIPO1), Long.valueOf("1"));
//            computadoraDAO.guardar(new ComputadoraDTO("abc23", "199.555.33", 2, TipoComputadora.TIPO1), Long.valueOf("1"));
//            computadoraDAO.guardar(new ComputadoraDTO("abc25", "199.555.33", 3, TipoComputadora.TIPO1), Long.valueOf("1"));
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            List<ComputadoraEntidad> computadoras = laboratorioComputoDAO.obtenerPorId(Long.valueOf("1")).getComputadoras();
//            for (ComputadoraEntidad computadora : computadoras) {
//                System.out.println("computadora: " + computadora.getNoMaquina() + " Estatus: " + computadora.getEstatus());
//            }
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }

        //Actualiza: correcto
//        try {
//            carreraDAO.actualizar(Long.valueOf("1"), new CarreraDTO("Ing Quimica", LocalTime.of(0, 6, 0)));
//            estudianteDAO.actualizar(Long.valueOf("1"), new EstudianteDTO("Cebra", "Cazares", "Patino", "abc123"));
//            estudianteDAO.actualizar(Long.valueOf("2"), new EstudianteDTO("Zendaya", "Zayas", "Lopez", "abc456"));
//            estudianteDAO.actualizar(Long.valueOf("3"), new EstudianteDTO("Susie", "Sierra", "Montes"));
//            unidadAcademicaDAO.actualizar(Long.valueOf("1"), new UnidadAcademicaDTO("ITSON Nainari"));
//            laboratorioComputoDAO.actualizar(Long.valueOf("1"), new LaboratorioComputoDTO("cisco", LocalTime.of(0, 30), LocalTime.of(17, 30)));
//            computadoraDAO.actualizar(Long.valueOf("1"), new ComputadoraDTO("abc12", "199.999.33", 1, TipoComputadora.TIPO1));
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            List<ComputadoraEntidad> computadoras = laboratorioComputoDAO.obtenerPorId(Long.valueOf("1")).getComputadoras();
//            for (ComputadoraEntidad computadora : computadoras) {
//                System.out.println("computadora: " + computadora.getNoMaquina() + " Estatus: " + computadora.getEstatus() + computadora.getDireccionIP());
//            }
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }

        //elimina: correcto
//        try {
//            estudianteDAO.eliminar(Long.valueOf("1"));
//            computadoraDAO.eliminar(Long.valueOf("1"));
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }

        //aparta: correcto
//        try{
//            apartadoDAO.apartar(Long.valueOf("1"), Long.valueOf("1"));
//            apartadoDAO.apartar(Long.valueOf("2"), Long.valueOf("3"));
//            apartadoDAO.apartar(Long.valueOf("3"), Long.valueOf("2"));
//        }catch(PersistenciaException pe){
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, pe);
//        }
        
        //desaparta: correcto
//        try{
//            apartadoDAO.desapartar(Long.valueOf("4"));
//            apartadoDAO.desapartar(Long.valueOf("5"));
//            apartadoDAO.desapartar(Long.valueOf("6"));
//        }catch(PersistenciaException pe){
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, pe);
//        }
        
        //bloquea: correcto
        try{
            bloqueoDAO.guardar(new BloqueoDTO("Ver paginas indebidas"));
            bloqueoDAO.guardar(new BloqueoDTO("Jugar brawl stars"));
            estudianteBloqueoDAO.bloquear(Long.valueOf("1"), Long.valueOf("1"));
            estudianteBloqueoDAO.bloquear(Long.valueOf("2"), Long.valueOf("2"));
        }catch(PersistenciaException pe){
            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, pe);
        }
        
        //desbloquea: correcto
        try{
            estudianteBloqueoDAO.desbloquear(Long.valueOf("1"));
        }catch(PersistenciaException pe){
            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, pe);
        }
    
        //Enlista Entidades: correcto
//        try{
//            List<EstudianteEntidad> estudiantes= estudianteDAO.obtenerEstudiantes();
//            for (EstudianteEntidad estudiante : estudiantes) {
//                System.out.println(estudiante.toString());
//            }
//        }catch(PersistenciaException pe){
//            Logger.getLogger(testPersistencia.class.getName()).log(Level.SEVERE, null, pe);
//        }
    }   
}
