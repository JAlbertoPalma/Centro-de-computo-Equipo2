package negocio.convertidores;

import dto.LaboratorioComputoDTO;
import entidad.LaboratorioComputoEntidad;

/**
 * La clase LaboratorioCVR se encarga de la conversión entre la entidad
 * LaboratorioComputoEntidad y su representación en Data Transfer Object (DTO),
 * LaboratorioComputoDTO. Esta clase forma parte del patrón de diseño de
 * conversores, que facilita la manipulación de datos entre diferentes capas de
 * la aplicación, mejorando la transferencia de datos y la separación de
 * preocupaciones.
 *
 * @author Brandon Valenzuela
 */
public class LaboratorioComputoCVR {

    /**
     * Convierte un objeto LaboratorioComputoDTO en una entidad LaboratorioComputoEntidad.
     *
     * @param laboratorioDTO El objeto LaboratorioComputoDTO que se desea convertir.
     * @return Un objeto LaboratorioComputoEntidad correspondiente a los datos del DTO.
     */
    public LaboratorioComputoEntidad laboratorioDTO_entidad(LaboratorioComputoDTO laboratorioDTO) {
        // Crea una nueva instancia de LaboratorioComputoEntidad
        LaboratorioComputoEntidad laboratorioEntidad = new LaboratorioComputoEntidad();
        
        // Asigna los valores del DTO a la entidad
        laboratorioEntidad.setNombre(laboratorioDTO.getNombre());
        laboratorioEntidad.setHoraInicio(laboratorioDTO.getHoraInicio());
        laboratorioEntidad.setHoraFin(laboratorioDTO.getHoraFin());
        
        // Retorna la entidad
        return laboratorioEntidad;
    }

    /**
     * Convierte un objeto LaboratorioComputoEntidad en un DTO LaboratorioComputoDTO.
     *
     * @param laboratorioEntidad El objeto LaboratorioComputoEntidad que se desea convertir.
     * @return Un objeto LaboratorioComputoDTO correspondiente a los datos de la entidad.
     */
    public LaboratorioComputoDTO entidad_laboratorioDTO(LaboratorioComputoEntidad laboratorioEntidad) {
        // Crea una nueva instancia de LaboratorioComputoDTO
        LaboratorioComputoDTO laboratorioDTO = new LaboratorioComputoDTO();
        
        // Asigna los valores de la entidad al DTO
        laboratorioDTO.setNombre(laboratorioEntidad.getNombre());
        laboratorioDTO.setHoraInicio(laboratorioEntidad.getHoraInicio());
        laboratorioDTO.setHoraFin(laboratorioEntidad.getHoraFin());
        
        // Retorna el DTO
        return laboratorioDTO;
    }
}
