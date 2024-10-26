package entidad;

import entidad.EstudianteBloqueoEntidad;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-25T21:57:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(BloqueoEntidad.class)
public class BloqueoEntidad_ { 

    public static volatile SingularAttribute<BloqueoEntidad, String> motivo;
    public static volatile SingularAttribute<BloqueoEntidad, LocalDate> fechaInicio;
    public static volatile SingularAttribute<BloqueoEntidad, Long> id;
    public static volatile ListAttribute<BloqueoEntidad, EstudianteBloqueoEntidad> estudiantes;
    public static volatile SingularAttribute<BloqueoEntidad, LocalDate> fechaFin;

}