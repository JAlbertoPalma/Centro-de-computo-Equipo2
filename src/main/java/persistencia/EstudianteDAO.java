/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.ComputadoraDTO;
import dto.EstudianteDTO;
import entidad.CarreraEntidad;
import entidad.ComputadoraEntidad;
import entidad.EstudianteEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.ICarreraDAO;
import persistencia.interfaces.IEstudianteDAO;

/**
 *
 * @author Beto_
 */
public class EstudianteDAO implements IEstudianteDAO{
    @PersistenceContext
    private EntityManager entityManager;
    private ICarreraDAO carreraDAO;
    
    @Override
    public void guardar(EstudianteDTO estudianteDTO, Long id_carrera) throws PersistenciaException{
        try{
            carreraDAO = new CarreraDAO();
            entityManager.getTransaction().begin();
            CarreraEntidad carreraBuscada = carreraDAO.obtenerPorId(id_carrera);

            EstudianteEntidad estudiante = new EstudianteEntidad(
                    estudianteDTO.getNombres(),
                    estudianteDTO.getApellidoPaterno(),
                    estudianteDTO.getApellidoMaterno(),
                    estudianteDTO.getContrasena(),
                    carreraBuscada);
            entityManager.persist(estudiante);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(Exception e){
            throw new PersistenciaException(e.getMessage());
        }
    }
    
    @Override //!
    public void actualizar(Long id, EstudianteDTO estudianteDTO) throws PersistenciaException{
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el estudiante a actualizar
            EstudianteEntidad estudianteBuscado = obtenerPorId(id);
            
            //Se actualizan los valores del estudiante
            estudianteBuscado.setNombres(estudianteDTO.getNombres());
            estudianteBuscado.setApellidoPaterno(estudianteDTO.getApellidoPaterno());
            estudianteBuscado.setApellidoMaterno(estudianteDTO.getApellidoMaterno());
            estudianteBuscado.setContrasena(estudianteDTO.getContrasena()); //!
            
            entityManager.merge(estudianteBuscado);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException{
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el estudiante a eliminar
            EstudianteEntidad estudianteBuscado = obtenerPorId(id);
            
            //Elimina el estudiante y termina la transacción
            entityManager.remove(estudianteBuscado);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public EstudianteEntidad obtenerPorId(Long id) throws PersistenciaException{
        EstudianteEntidad estudianteBuscado = entityManager.find(EstudianteEntidad.class, id);
        if(estudianteBuscado == null){
                throw new PersistenciaException("No se encontró al estudiante con el id");
            }
        return estudianteBuscado;
    }

    @Override
    public List<EstudianteEntidad> obtenerEstudiantes() throws PersistenciaException{
        List<EstudianteEntidad> estudiantes = entityManager.createQuery("SELECT e FROM EstudianteEntidad e", EstudianteEntidad.class)
                .getResultList();
        if(estudiantes == null || estudiantes.isEmpty()){
            throw new PersistenciaException("No hay estudiantes por mostrar");
        }
        return estudiantes;
    }
    
    public void apartarComputadora(Long id_computadora){
        //buscar compu por id
    }
    
    public void bloquearEstudiante(){
        
    }
    
    public void desbloquearEstudiante(){
        
    }
    
}
