package entidad;

import entidad.ComputadoraEntidad;
import entidad.EstudianteEntidad;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-26T20:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ApartadoEntidad.class)
public class ApartadoEntidad_ { 

    public static volatile SingularAttribute<ApartadoEntidad, LocalTime> horaFin;
    public static volatile SingularAttribute<ApartadoEntidad, EstudianteEntidad> estudiante;
    public static volatile SingularAttribute<ApartadoEntidad, Long> id;
    public static volatile SingularAttribute<ApartadoEntidad, ComputadoraEntidad> computadora;
    public static volatile SingularAttribute<ApartadoEntidad, LocalTime> horaInicio;
    public static volatile SingularAttribute<ApartadoEntidad, Long> segundosActividad;

}