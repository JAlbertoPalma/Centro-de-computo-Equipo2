package entidad;

import entidad.LaboratorioComputoEntidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-26T20:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(UnidadAcademicaEntidad.class)
public class UnidadAcademicaEntidad_ { 

    public static volatile ListAttribute<UnidadAcademicaEntidad, LaboratorioComputoEntidad> laboratoriosComputo;
    public static volatile SingularAttribute<UnidadAcademicaEntidad, Long> id;
    public static volatile SingularAttribute<UnidadAcademicaEntidad, String> nombre;

}