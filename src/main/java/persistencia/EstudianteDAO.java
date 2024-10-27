/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.EstudianteDTO;
import entidad.ApartadoEntidad;
import entidad.CarreraEntidad;
import entidad.ComputadoraEntidad;
import entidad.EstudianteEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.interfaces.IApartadoDAO;
import persistencia.interfaces.IBloqueoDAO;
import persistencia.interfaces.ICarreraDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;

/**
 *
 * @author Beto_
 */
public class EstudianteDAO implements IEstudianteDAO{
    
    private EntityManager entityManager;
    private ICarreraDAO carreraDAO;
    private IComputadoraDAO computadoraDAO;

    public EstudianteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.carreraDAO = new CarreraDAO(entityManager);
        this.computadoraDAO = new ComputadoraDAO(entityManager);
    }
    @Override
    public void guardar(EstudianteDTO estudianteDTO, Long id_carrera) throws PersistenciaException{
        try{
            entityManager.getTransaction().begin();
            CarreraEntidad carreraBuscada = carreraDAO.obtenerPorId(id_carrera);

            EstudianteEntidad estudiante = new EstudianteEntidad(
                    estudianteDTO.getNombres(),
                    estudianteDTO.getApellidoPaterno(),
                    estudianteDTO.getApellidoMaterno(),
                    estudianteDTO.getContrasena(),
                    carreraBuscada);
            carreraBuscada.getEstudiante().add(estudiante);
            entityManager.persist(estudiante);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
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
            
            entityManager.merge(estudianteBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    @Override
    public void actualizarEntidad(EstudianteEntidad estudianteEntidad) throws PersistenciaException{
        try{
            entityManager.merge(estudianteEntidad);
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException("No se pudo actualizar la entidad");
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
    
    
//    public List<EstudianteEntidad> obtenerEstudiantes(int pagina, int tamanioPagina, String ordenarPor) throws PersistenciaException {
//        TypedQuery<EstudianteEntidad> query = entityManager.createQuery(
//            "SELECT e FROM EstudianteEntidad e ORDER BY e." + ordenarPor,
//            EstudianteEntidad.class);
//        query.setFirstResult((pagina - 1) * tamanioPagina);
//        query.setMaxResults(tamanioPagina);
//        List<EstudianteEntidad> estudiantes = query.getResultList();
//    }
    
}
