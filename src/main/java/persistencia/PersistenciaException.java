/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 * Representa la excepción de la capa de persistencia
 * @author Beto_
 */
public class PersistenciaException extends Exception{
    /**
     * Excepción de la capa de persistencia
     */
    public PersistenciaException() {
    }
    
    /**
     * Excepción de la capa de persistencia
     * @param message mensaje de la causa
     */
    public PersistenciaException(String message) {
        super(message);
    }
}
