package negocio.interfaces;

import dto.SoftwareInstaladoDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Brandon Valenzuela
 */
public interface ISoftwareInstaladoNegocio {

    SoftwareInstaladoDTO crearSoftware(SoftwareInstaladoDTO software) throws NegocioException;

    SoftwareInstaladoDTO obtenerSoftware(Long id) throws NegocioException;
    
    List<SoftwareInstaladoDTO> obtenerListaSoftware();

    void eliminarSoftware(Long id) throws NegocioException;
}
