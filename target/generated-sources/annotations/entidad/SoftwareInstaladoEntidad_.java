package entidad;

import entidad.ComputadoraEntidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-26T20:08:55", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(SoftwareInstaladoEntidad.class)
public class SoftwareInstaladoEntidad_ { 

    public static volatile SingularAttribute<SoftwareInstaladoEntidad, Long> id;
    public static volatile SingularAttribute<SoftwareInstaladoEntidad, ComputadoraEntidad> computadora;
    public static volatile SingularAttribute<SoftwareInstaladoEntidad, String> nombre;

}