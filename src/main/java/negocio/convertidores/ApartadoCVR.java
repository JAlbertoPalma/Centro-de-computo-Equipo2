package negocio.convertidores;

import dto.ApartadoDTO;
import entidad.ApartadoEntidad;

/**
 * La clase ApartadoCVR se encarga de la conversión entre la entidad 
 * ApartadoEntidad y su representación en Data Transfer Object (DTO), 
 * ApartadoDTO. Facilita la transferencia de datos entre las capas de 
 * la aplicación al manejar la conversión de objetos.
 * 
 * @author Brandon Valenzuela
 */
public class ApartadoCVR {
    
    /**
     * Convierte un objeto ApartadoDTO en una entidad ApartadoEntidad.
     *
     * @param apartadoDTO El objeto ApartadoDTO que se desea convertir.
     * @return Un objeto ApartadoEntidad con los datos del DTO.
     */
    public ApartadoEntidad apartadoDTO_entidad(ApartadoDTO apartadoDTO) {
        // Crea una nueva instancia de ApartadoEntidad
        ApartadoEntidad apartadoEntidad = new ApartadoEntidad();
        
        // Asigna los valores del DTO a la entidad
        apartadoEntidad.setId(apartadoDTO.getId());
        apartadoEntidad.setHoraInicio(apartadoDTO.getHoraInicio());
        apartadoEntidad.setHoraFin(apartadoDTO.getHoraFin());
        apartadoEntidad.setSegundosActividad(apartadoDTO.getSegundosActividad());
        
        // Retorna la entidad
        return apartadoEntidad;
    }

    /**
     * Convierte un objeto ApartadoEntidad en un DTO ApartadoDTO.
     *
     * @param apartadoEntidad El objeto ApartadoEntidad que se desea convertir.
     * @return Un objeto ApartadoDTO con los datos de la entidad.
     */
    public ApartadoDTO entidad_apartadoDTO(ApartadoEntidad apartadoEntidad) {
        // Crea una nueva instancia de ApartadoDTO
        ApartadoDTO apartadoDTO = new ApartadoDTO();
        
        // Asigna los valores de la entidad al DTO
        apartadoDTO.setId(apartadoEntidad.getId());
        apartadoDTO.setHoraInicio(apartadoEntidad.getHoraInicio());
        apartadoDTO.setHoraFin(apartadoEntidad.getHoraFin());
        apartadoDTO.setSegundosActividad(apartadoEntidad.getSegundosActividad());
        
        // Retorna el DTO
        return apartadoDTO;
    }}
