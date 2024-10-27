package negocio.interfaces;

import dto.ComputadoraDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Brandon Valenzuela
 */
public interface IComputadoraNegocio {

    ComputadoraDTO crearComputadora(ComputadoraDTO computadora) throws NegocioException;

    ComputadoraDTO obtenerComputadora(Long id) throws NegocioException;

    List<ComputadoraDTO> obtenerListaComputadora();

    void eliminarComputadora(Long id) throws NegocioException;

    void actualizarComputadora(ComputadoraDTO computadora) throws NegocioException;

    void cambiarEstatus(Long id, String nuevoEstatus) throws NegocioException;

}
