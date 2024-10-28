package negocio.interfaces;

import dto.CarreraDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Brandon Valenzuela
 */
public interface ICarreraNegocio {

    CarreraDTO crearCarrera(CarreraDTO carrera) throws NegocioException;

    CarreraDTO obtenerCarrera(Long id) throws NegocioException;
    
    List<CarreraDTO> obtenerListaCarreras();

    void eliminarCarrera(Long id) throws NegocioException;
    
}
