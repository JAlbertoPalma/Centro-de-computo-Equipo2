/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dto.EstudianteDTO;
import entidad.CarreraEntidad;
import entidad.EstudianteEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import persistencia.interfaces.ICarreraDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;

/**
 * Representa la clase DAO que gestiona las operaciones
 * del estudiante en la base de datos
 * @author Beto_
 */
public class EstudianteDAO implements IEstudianteDAO{
    
    private EntityManager entityManager;
    private ICarreraDAO carreraDAO;
    private IComputadoraDAO computadoraDAO;
    
    /**
     * Construye un estudianteDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public EstudianteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.carreraDAO = new CarreraDAO(entityManager);
        this.computadoraDAO = new ComputadoraDAO(entityManager);
    }
    
    /**
     * Persiste un estudiante con un DTO y una carrera a asociar
     * @param estudianteDTO el DTO del estudiante
     * @param id_carrera el id de la carrera
     * @throws PersistenciaException si no se puede persistir
     */
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
    
    /**
     * Actualiza el estudiante con un DTO y id
     * @param id el id del estudiante
     * @param estudianteDTO el DTO del estudiante
     * @throws PersistenciaException si no se puede actualizar
     */
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
    
    /**
     * Actualiza la entidad con otra entidad
     * @param estudianteEntidad la entidad para actualizar
     * @throws PersistenciaException si no se puede actualizar la entidad
     */
    @Override
    public void actualizarEntidad(EstudianteEntidad estudianteEntidad) throws PersistenciaException{
        try{
            entityManager.merge(estudianteEntidad);
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }
    
    /**
     * Se elimina un estudiante por su id
     * @param id el id del estudiante
     * @throws PersistenciaException si no se logra eliminar
     */
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
    
    /**
     * Se obtiene un estudiante por su id
     * @param id el id del estudiante
     * @return un estudiante entidad
     * @throws PersistenciaException si no se logra obtener
     */
    @Override
    public EstudianteEntidad obtenerPorId(Long id) throws PersistenciaException{
        EstudianteEntidad estudianteBuscado = entityManager.find(EstudianteEntidad.class, id);
        if(estudianteBuscado == null){
            throw new PersistenciaException("No se encontró al estudiante con el id");
        }
        return estudianteBuscado;
    }

    /**
     * Obtiene la lista de estudiantes entidad
     * @return la lista de estudiantes entidad
     * @throws PersistenciaException si la lista esta vacía
     */
    @Override
    public List<EstudianteEntidad> obtenerEstudiantes() throws PersistenciaException{
        List<EstudianteEntidad> estudiantes = entityManager.createQuery("SELECT e FROM EstudianteEntidad e", EstudianteEntidad.class)
                .getResultList();
        if(estudiantes == null || estudiantes.isEmpty()){
            throw new PersistenciaException("No hay estudiantes por mostrar");
        }
        return estudiantes;
    }  
    
    @Override
    public List<EstudianteEntidad> obtenerEstudiantesLimite(int pagina, int tamanioPagina) throws PersistenciaException {
        TypedQuery<EstudianteEntidad> query = entityManager.createQuery(
            "SELECT e FROM EstudianteEntidad e",
            EstudianteEntidad.class);
        query.setFirstResult((pagina - 1) * tamanioPagina);
        query.setMaxResults(tamanioPagina);
        List<EstudianteEntidad> estudiantes = query.getResultList();
        return estudiantes;
    }
    
}
