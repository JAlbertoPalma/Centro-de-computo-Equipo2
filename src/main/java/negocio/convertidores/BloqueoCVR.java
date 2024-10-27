/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.convertidores;

import dto.BloqueoDTO;
import entidad.BloqueoEntidad;

/**
 * La clase BloqueoCVR se encarga de la conversión entre la entidad 
 * BloqueoEntidad y su representación en Data Transfer Object (DTO), 
 * BloqueoDTO. Facilita la transferencia de datos entre las capas de 
 * la aplicación al manejar la conversión de objetos.
 * 
 * @author Brandon Valenzuela 
 */
public class BloqueoCVR {
    
    /**
     * Convierte un objeto BloqueoDTO en una entidad BloqueoEntidad.
     *
     * @param bloqueoDTO El objeto BloqueoDTO que se desea convertir.
     * @return Un objeto BloqueoEntidad con los datos del DTO.
     */
    public BloqueoEntidad bloqueoDTO_a_entidad(BloqueoDTO bloqueoDTO) {
        // Crea una nueva instancia de BloqueoEntidad
        BloqueoEntidad bloqueoEntidad = new BloqueoEntidad();
        
        // Asigna los valores del DTO a la entidad
        bloqueoEntidad.setMotivo(bloqueoDTO.getMotivo());
        
        // Retorna la entidad
        return bloqueoEntidad;
    }

    /**
     * Convierte un objeto BloqueoEntidad en un DTO BloqueoDTO.
     *
     * @param bloqueoEntidad El objeto BloqueoEntidad que se desea convertir.
     * @return Un objeto BloqueoDTO con los datos de la entidad.
     */
    public BloqueoDTO entidad_a_bloqueoDTO(BloqueoEntidad bloqueoEntidad) {
        // Crea una nueva instancia de BloqueoDTO
        BloqueoDTO bloqueoDTO = new BloqueoDTO();
        
        // Asigna los valores de la entidad al DTO
        bloqueoDTO.setMotivo(bloqueoEntidad.getMotivo());
        
        // Retorna el DTO
        return bloqueoDTO;
    }
}
