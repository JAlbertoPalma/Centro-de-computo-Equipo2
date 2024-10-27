package entidad;

import entidad.ComputadoraEntidad;
import entidad.UnidadAcademicaEntidad;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-26T20:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(LaboratorioComputoEntidad.class)
public class LaboratorioComputoEntidad_ { 

    public static volatile SingularAttribute<LaboratorioComputoEntidad, LocalTime> horaFin;
    public static volatile SingularAttribute<LaboratorioComputoEntidad, UnidadAcademicaEntidad> unidadAcademica;
    public static volatile SingularAttribute<LaboratorioComputoEntidad, Long> id;
    public static volatile SingularAttribute<LaboratorioComputoEntidad, String> nombre;
    public static volatile SingularAttribute<LaboratorioComputoEntidad, LocalTime> horaInicio;
    public static volatile ListAttribute<LaboratorioComputoEntidad, ComputadoraEntidad> computadoras;

}