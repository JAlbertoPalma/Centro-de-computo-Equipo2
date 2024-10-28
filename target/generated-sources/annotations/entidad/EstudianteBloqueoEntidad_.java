package entidad;

import entidad.BloqueoEntidad;
import entidad.EstudianteEntidad;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-28T00:10:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(EstudianteBloqueoEntidad.class)
public class EstudianteBloqueoEntidad_ { 

    public static volatile SingularAttribute<EstudianteBloqueoEntidad, EstudianteEntidad> estudiante;
    public static volatile SingularAttribute<EstudianteBloqueoEntidad, LocalDate> fechaInicio;
    public static volatile SingularAttribute<EstudianteBloqueoEntidad, Long> id;
    public static volatile SingularAttribute<EstudianteBloqueoEntidad, BloqueoEntidad> bloqueo;
    public static volatile SingularAttribute<EstudianteBloqueoEntidad, LocalDate> fechaFin;

}