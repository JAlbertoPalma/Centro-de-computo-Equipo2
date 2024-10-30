package entidad;

import entidad.ApartadoEntidad;
import entidad.CarreraEntidad;
import entidad.EstudianteBloqueoEntidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-28T13:28:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(EstudianteEntidad.class)
public class EstudianteEntidad_ { 

    public static volatile SingularAttribute<EstudianteEntidad, String> apellidoPaterno;
    public static volatile SingularAttribute<EstudianteEntidad, Boolean> estaInscrito;
    public static volatile SingularAttribute<EstudianteEntidad, String> contrasena;
    public static volatile SingularAttribute<EstudianteEntidad, Long> id;
    public static volatile SingularAttribute<EstudianteEntidad, Boolean> estaBloqueado;
    public static volatile SingularAttribute<EstudianteEntidad, CarreraEntidad> carrera;
    public static volatile ListAttribute<EstudianteEntidad, EstudianteBloqueoEntidad> bloqueos;
    public static volatile SingularAttribute<EstudianteEntidad, String> nombres;
    public static volatile SingularAttribute<EstudianteEntidad, String> apellidoMaterno;
    public static volatile ListAttribute<EstudianteEntidad, ApartadoEntidad> computadoras;

}