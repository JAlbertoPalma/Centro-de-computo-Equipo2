package negocio.convertidores;

import dto.UnidadAcademicaDTO;
import entidad.UnidadAcademicaEntidad;

/**
 * La clase UnidadAcademicaCVR maneja la conversión entre la entidad UnidadAcademicaEntidad
 * y su correspondiente DTO UnidadAcademicaDTO, permitiendo el intercambio de datos entre
 * las capas de entidad y DTO en la aplicación.
 * 
 * @author Brandon Valenzuela
 */
public class UnidadAcademicaCVR {
    
    /**
     * Convierte un objeto UnidadAcademicaDTO en una entidad UnidadAcademicaEntidad.
     *
     * @param unidadAcademicaDTO El objeto UnidadAcademicaDTO que se desea convertir.
     * @return Un objeto UnidadAcademicaEntidad con los datos del DTO.
     */
    public UnidadAcademicaEntidad unidadAcademicaDTO_a_entidad(UnidadAcademicaDTO unidadAcademicaDTO) {
        // Crea una nueva instancia de UnidadAcademicaEntidad
        UnidadAcademicaEntidad unidadAcademicaEntidad = new UnidadAcademicaEntidad();
        
        // Asigna los valores del DTO a la entidad
        unidadAcademicaEntidad.setNombre(unidadAcademicaDTO.getNombre());
        
        // Retorna la entidad
        return unidadAcademicaEntidad;
    }

    /**
     * Convierte un objeto UnidadAcademicaEntidad en un DTO UnidadAcademicaDTO.
     *
     * @param unidadAcademicaEntidad El objeto UnidadAcademicaEntidad que se desea convertir.
     * @return Un objeto UnidadAcademicaDTO con los datos de la entidad.
     */
    public UnidadAcademicaDTO entidad_a_unidadAcademicaDTO(UnidadAcademicaEntidad unidadAcademicaEntidad) {
        // Crea una nueva instancia de UnidadAcademicaDTO
        UnidadAcademicaDTO unidadAcademicaDTO = new UnidadAcademicaDTO();
        
        // Asigna los valores de la entidad al DTO
        unidadAcademicaDTO.setNombre(unidadAcademicaEntidad.getNombre());
        
        // Retorna el DTO
        return unidadAcademicaDTO;
    }
}
