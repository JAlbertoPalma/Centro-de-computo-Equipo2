package negocio.convertidores;

import dto.SoftwareInstaladoDTO;
import entidad.SoftwareInstaladoEntidad;

/**
 * La clase SoftwareInstaladoCVR se encarga de la conversión entre la entidad
 * SoftwareInstaladoEntidad y su representación en Data Transfer Object (DTO), 
 * SoftwareInstaladoDTO. Esta clase es parte del patrón de diseño de conversores 
 * que facilita la transferencia de datos y la separación de preocupaciones 
 * entre diferentes capas de la aplicación.
 * 
 * @author Brandon Valenzuela
 */
public class SoftwareInstaladoCVR {
    
    /**
     * Convierte un objeto SoftwareInstaladoDTO en una entidad SoftwareInstaladoEntidad.
     *
     * @param softwareDTO El objeto SoftwareInstaladoDTO que se desea convertir.
     * @return Un objeto SoftwareInstaladoEntidad correspondiente a los datos del DTO.
     */
    public SoftwareInstaladoEntidad softwareDTO_entidad(SoftwareInstaladoDTO softwareDTO) {
        // Crea una nueva instancia de SoftwareInstaladoEntidad
        SoftwareInstaladoEntidad softwareEntidad = new SoftwareInstaladoEntidad();
        
        // Asigna los valores del DTO a la entidad
        softwareEntidad.setNombre(softwareDTO.getNombre());
        
        // Retorna la entidad
        return softwareEntidad;
    }

    /**
     * Convierte un objeto SoftwareInstaladoEntidad en un DTO SoftwareInstaladoDTO.
     *
     * @param softwareEntidad El objeto SoftwareInstaladoEntidad que se desea convertir.
     * @return Un objeto SoftwareInstaladoDTO correspondiente a los datos de la entidad.
     */
    public SoftwareInstaladoDTO entidad_softwareDTO(SoftwareInstaladoEntidad softwareEntidad) {
        // Crea una nueva instancia de SoftwareInstaladoDTO
        SoftwareInstaladoDTO softwareDTO = new SoftwareInstaladoDTO();
        
        // Asigna los valores de la entidad al DTO
        softwareDTO.setNombre(softwareEntidad.getNombre());
        
        // Retorna el DTO
        return softwareDTO;
    }
}
