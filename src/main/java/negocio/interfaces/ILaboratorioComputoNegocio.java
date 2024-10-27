/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.interfaces;

import dto.LaboratorioComputoDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author brand
 */
public interface ILaboratorioComputoNegocio {

    LaboratorioComputoDTO crearLaboratorio(LaboratorioComputoDTO laboratorio) throws NegocioException;

    LaboratorioComputoDTO obtenerLaboratorio(Long id) throws NegocioException;
    
    List<LaboratorioComputoDTO> obtenerListaLaboratoriosComputo();

    void eliminarLaboratorio(Long id) throws NegocioException;

    void actualizarLaboratorio(LaboratorioComputoDTO laboratorio) throws NegocioException;

}
