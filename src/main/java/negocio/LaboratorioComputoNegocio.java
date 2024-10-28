package negocio;

import dto.LaboratorioComputoDTO;
import entidad.LaboratorioComputoEntidad;
import persistencia.interfaces.ILaboratorioComputoDAO;
import negocio.convertidores.LaboratorioComputoCVR;
import negocio.exception.NegocioException;
import negocio.interfaces.ILaboratorioComputoNegocio;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de negocio que maneja las operaciones relacionadas con LaboratorioComputo.
 * Esta clase implementa la lógica de negocio y utiliza DAO para la persistencia.
 * 
 * @author Brandon Valenzuela
 */
public class LaboratorioComputoNegocio implements ILaboratorioComputoNegocio {

    private final ILaboratorioComputoDAO laboratorioComputoDAO;
    private final LaboratorioComputoCVR convertidor;

    /**
     * Constructor que inicializa el DAO y el convertidor.
     * @param laboratorioComputoDAO DAO de LaboratorioComputo
     */
    public LaboratorioComputoNegocio(ILaboratorioComputoDAO laboratorioComputoDAO) {
        this.laboratorioComputoDAO = laboratorioComputoDAO;
        this.convertidor = new LaboratorioComputoCVR();
    }

    /**
     * Crea un nuevo laboratorio de cómputo.
     * @param laboratorio El DTO del laboratorio a crear
     * @return El laboratorio creado en formato DTO
     * @throws NegocioException si ocurre un error de negocio o persistencia
     */
    @Override
    public LaboratorioComputoDTO crearLaboratorio(LaboratorioComputoDTO laboratorio) throws NegocioException {
        try {
            LaboratorioComputoEntidad entidad = convertidor.laboratorioDTO_entidad(laboratorio);
            laboratorioComputoDAO.guardar(laboratorio, entidad.getUnidadAcademica().getId());
            return convertidor.entidad_laboratorioDTO(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al crear laboratorio de cómputo: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene un laboratorio de cómputo por su ID.
     * @param id El ID del laboratorio
     * @return El laboratorio en formato DTO
     * @throws NegocioException si el laboratorio no existe o ocurre un error
     */
    @Override
    public LaboratorioComputoDTO obtenerLaboratorio(Long id) throws NegocioException {
        try {
            LaboratorioComputoEntidad entidad = laboratorioComputoDAO.obtenerPorId(id);
            return convertidor.entidad_laboratorioDTO(entidad);
        } catch (Exception e) {
            throw new NegocioException("Error al obtener el laboratorio de cómputo con ID: " + id, e);
        }
    }

    /**
     * Obtiene una lista de todos los laboratorios de cómputo.
     * @return Una lista de laboratorios en formato DTO
     * @throws NegocioException si ocurre un error al obtener la lista
     */
    @Override
    public List<LaboratorioComputoDTO> obtenerListaLaboratoriosComputo() throws NegocioException {
        try {
            List<LaboratorioComputoEntidad> entidades = laboratorioComputoDAO.obtenerLaboratoriosComputo();
            return entidades.stream()
                    .map(convertidor::entidad_laboratorioDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NegocioException("Error al obtener la lista de laboratorios de cómputo", e);
        }
    }

    /**
     * Elimina un laboratorio de cómputo por su ID.
     * @param id El ID del laboratorio a eliminar
     * @throws NegocioException si ocurre un error al eliminar el laboratorio
     */
    @Override
    public void eliminarLaboratorio(Long id) throws NegocioException {
        try {
            laboratorioComputoDAO.eliminar(id);
        } catch (Exception e) {
            throw new NegocioException("Error al eliminar el laboratorio de cómputo con ID: " + id, e);
        }
    }

    /**
     * Actualiza los datos de un laboratorio de cómputo.
     * @param laboratorio El DTO del laboratorio con los nuevos datos
     * @throws NegocioException si ocurre un error al actualizar el laboratorio
     */
    @Override
    public void actualizarLaboratorio(LaboratorioComputoDTO laboratorio) throws NegocioException {
        try {
            LaboratorioComputoEntidad entidad = convertidor.laboratorioDTO_entidad(laboratorio);
            laboratorioComputoDAO.actualizar(entidad.getId(), laboratorio);
        } catch (Exception e) {
            throw new NegocioException("Error al actualizar el laboratorio de cómputo", e);
        }
    }
}
