package entidad;

import entidad.EstudianteEntidad;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-28T13:28:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(CarreraEntidad.class)
public class CarreraEntidad_ { 

    public static volatile ListAttribute<CarreraEntidad, EstudianteEntidad> estudiante;
    public static volatile SingularAttribute<CarreraEntidad, Long> id;
    public static volatile SingularAttribute<CarreraEntidad, String> nombre;
    public static volatile SingularAttribute<CarreraEntidad, LocalTime> tiempoLimite;

}