/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.convertidores;

import dto.CarreraDTO;
import entidad.CarreraEntidad;

/**
 * La clase CarreraCVR se encarga de la conversión entre la entidad
 * CarreraEntidad y su representación en Data Transfer Object (DTO), CarreraDTO.
 * Esta clase es parte del patrón de diseño de conversores que permite
 * simplificar la manipulación de datos entre diferentes capas de la aplicación,
 * facilitando la transferencia de datos y la separación de preocupaciones.
 *
 * @author Brandon Valenzuela
 */
public class CarreraCVR {
    
    /**
     * Convierte un objeto CarreraDTO en una entidad CarreraEntidad.
     *
     * @param carreraDTO El objeto CarreraDTO que se desea convertir.
     * @return Un objeto CarreraEntidad correspondiente a los datos del DTO.
     */
    public CarreraEntidad carreraDTO_entidad(CarreraDTO carreraDTO) {
        // Crea una nueva instancia de CarreraEntidad
        CarreraEntidad carreraEntidad = new CarreraEntidad();
        
        // Asigna los valores del DTO a la entidad
        carreraEntidad.setNombre(carreraDTO.getNombre());
        carreraEntidad.setTiempoLimite(carreraDTO.getTiempoLimite());
        
        // Retorna la entidad
        return carreraEntidad;
    }
    
    /**
     * Convierte un objeto CarreraEntidad en un DTO CarreraDTO.
     *
     * @param carreraEntidad El objeto CarreraEntidad que se desea convertir.
     * @return Un objeto CarreraDTO correspondiente a los datos de la entidad.
     */
    public CarreraDTO entidad_carreraDTO(CarreraEntidad carreraEntidad) {
        // Crea una nueva instancia de CarreraDTO
        CarreraDTO carreraDTO = new CarreraDTO();
        
        // Asigna los valores de la entidad al DTO
        carreraDTO.setNombre(carreraEntidad.getNombre());
        carreraDTO.setTiempoLimite(carreraEntidad.getTiempoLimite());
        
        // Retorna el DTO
        return carreraDTO;
    }
}
