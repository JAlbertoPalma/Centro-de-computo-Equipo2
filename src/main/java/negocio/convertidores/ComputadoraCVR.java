package negocio.convertidores;

import dto.ComputadoraDTO;
import entidad.ComputadoraEntidad;

/**
 * La clase ComputadoraCVR se encarga de la conversión entre la entidad
 * ComputadoraEntidad y su representación en Data Transfer Object (DTO), 
 * ComputadoraDTO. Esta clase es parte del patrón de diseño de conversores 
 * que permite simplificar la manipulación de datos entre diferentes capas 
 * de la aplicación, facilitando la transferencia de datos y la separación 
 * de preocupaciones.
 *    
 * @author Brandon Valenzuela
 */
public class ComputadoraCVR {
     /**
     * Convierte un objeto ComputadoraDTO en una entidad ComputadoraEntidad.
     *
     * @param computadoraDTO El objeto ComputadoraDTO que se desea convertir.
     * @return Un objeto ComputadoraEntidad correspondiente a los datos del DTO.
     */
    public ComputadoraEntidad computadoraDTO_entidad(ComputadoraDTO computadoraDTO) {
        // Crea una nueva instancia de ComputadoraEntidad
        ComputadoraEntidad computadoraEntidad = new ComputadoraEntidad();
        
        // Asigna los valores del DTO a la entidad
        computadoraEntidad.setContrasenaMaestra(computadoraDTO.getContrasenaMaestra());
        computadoraEntidad.setDireccionIP(computadoraDTO.getDireccionIP());
        computadoraEntidad.setNoMaquina(computadoraDTO.getNoMaquina());
        computadoraEntidad.setTipo(computadoraDTO.getTipo());
        computadoraEntidad.setEstatus(computadoraDTO.getEstatus());
        
        // Retorna la entidad
        return computadoraEntidad;
    }
    
    /**
     * Convierte un objeto ComputadoraEntidad en un DTO ComputadoraDTO.
     *
     * @param computadoraEntidad El objeto ComputadoraEntidad que se desea convertir.
     * @return Un objeto ComputadoraDTO correspondiente a los datos de la entidad.
     */
    public ComputadoraDTO entidad_computadoraDTO(ComputadoraEntidad computadoraEntidad) {
        // Crea una nueva instancia de ComputadoraDTO
        ComputadoraDTO computadoraDTO = new ComputadoraDTO();
        
        // Asigna los valores de la entidad al DTO
        computadoraDTO.setContrasenaMaestra(computadoraEntidad.getContrasenaMaestra());
        computadoraDTO.setDireccionIP(computadoraEntidad.getDireccionIP());
        computadoraDTO.setNoMaquina(computadoraEntidad.getNoMaquina());
        computadoraDTO.setTipo(computadoraEntidad.getTipo());
        computadoraDTO.setEstatus(computadoraEntidad.getEstatus());
        
        // Retorna el DTO
        return computadoraDTO;
    }
}
