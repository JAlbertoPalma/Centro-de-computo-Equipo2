package negocio.interfaces;

import dto.UnidadAcademicaDTO;
import java.util.List;

/**
 *
 * @author Brandon Valenzuela
 */
public interface IUnidadAcademicaNegocio {

    UnidadAcademicaDTO crearUnidadAcademica(UnidadAcademicaDTO unidad) throws Exception;

    UnidadAcademicaDTO obtenerUnidadAcademica(Long id) throws Exception;

    List<UnidadAcademicaDTO> obtenerListaUnidadesAcademicas();

    void eliminarUnidadAcademica(Long id) throws Exception;
}
