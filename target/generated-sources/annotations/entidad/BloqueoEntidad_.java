package entidad;

import entidad.EstudianteBloqueoEntidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-28T00:10:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(BloqueoEntidad.class)
public class BloqueoEntidad_ { 

    public static volatile SingularAttribute<BloqueoEntidad, String> motivo;
    public static volatile SingularAttribute<BloqueoEntidad, Long> id;
    public static volatile ListAttribute<BloqueoEntidad, EstudianteBloqueoEntidad> estudiantes;

}