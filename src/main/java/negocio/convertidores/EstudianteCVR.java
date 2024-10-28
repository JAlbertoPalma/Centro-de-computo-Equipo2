/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.convertidores;

import dto.EstudianteDTO;
import entidad.EstudianteEntidad;

/**
 * La clase EstudianteCVR se encarga de la conversión entre la entidad
 * EstudianteEntidad y su representación en Data Transfer Object (DTO), EstudianteDTO. 
 * Esta clase es parte del patrón de diseño de conversores quepermite simplificar 
 * la manipulación de datos entre diferentes capas de la aplicación, facilitando 
 * la transferencia de datos y la separación de preocupaciones.
 *
 * @author Brandon Valenzuela
 */
public class EstudianteCVR {

    /**
     * Convierte un objeto EstudianteDTO en una entidad EstudianteEntidad.
     *
     * @param estudianteDTO El objeto EstudianteDTO que se desea convertir.
     * @return Un objeto EstudianteEntidad que corresponde a los datos del DTO.
     */
    public EstudianteEntidad estudianteDTO_entidad(EstudianteDTO estudianteDTO) {
        // Crea una nueva instancia de EstudianteEntidad
        EstudianteEntidad estudianteEntidad = new EstudianteEntidad();

        // Asigna los valores del DTO a la entidad
        estudianteEntidad.setNombres(estudianteDTO.getNombres());
        estudianteEntidad.setApellidoPaterno(estudianteDTO.getApellidoPaterno());
        estudianteEntidad.setApellidoMaterno(estudianteDTO.getApellidoMaterno());
        estudianteEntidad.setContrasena(estudianteDTO.getContrasena());

        // Retorna la entidad
        return estudianteEntidad;
    }

    /**
     * }
     * Convierte un objeto EstudianteEntidad en un DTO EstudianteDTO.
     *
     * @param estudianteEntidad El objeto EstudianteEntidad que se desea
     * convertir.
     * @return Un objeto EstudianteDTO que corresponde a los datos de la
     * entidad.
     */
    public EstudianteDTO entidad_estudianteDTO(EstudianteEntidad estudianteEntidad) {
        // Crea una nueva instancia de EstudianteDTO
        EstudianteDTO estudianteDTO = new EstudianteDTO();

        // Asigna los valores de la entidad al DTO
        estudianteDTO.setNombres(estudianteEntidad.getNombres());
        estudianteDTO.setApellidoPaterno(estudianteEntidad.getApellidoPaterno());
        estudianteDTO.setApellidoMaterno(estudianteEntidad.getApellidoMaterno());
        estudianteDTO.setContrasena(estudianteEntidad.getContrasena());

        // Retorna el DTO
        return estudianteDTO;
    }
}
