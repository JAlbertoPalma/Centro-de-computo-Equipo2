package negocio.interfaces;

import dto.ApartadoDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Brandon Valenzuela
 */
public interface IApartadoNegocio {

    ApartadoDTO crearApartado(ApartadoDTO apartado) throws NegocioException;

    ApartadoDTO obtenerApartado(Long id) throws NegocioException;
    
    List<ApartadoDTO> obtenerListaApartado();

    void eliminarApartado(Long id) throws NegocioException;

    void actualizarApartado(ApartadoDTO apartado) throws Exception;
}
