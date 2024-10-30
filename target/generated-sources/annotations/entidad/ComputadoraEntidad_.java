package entidad;

import entidad.ApartadoEntidad;
import entidad.LaboratorioComputoEntidad;
import entidad.SoftwareInstaladoEntidad;
import enums.TipoComputadora;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-28T13:28:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ComputadoraEntidad.class)
public class ComputadoraEntidad_ { 

    public static volatile SingularAttribute<ComputadoraEntidad, String> contrasenaMaestra;
    public static volatile SingularAttribute<ComputadoraEntidad, TipoComputadora> tipo;
    public static volatile SingularAttribute<ComputadoraEntidad, String> estatus;
    public static volatile SingularAttribute<ComputadoraEntidad, LaboratorioComputoEntidad> laboratorioComputo;
    public static volatile ListAttribute<ComputadoraEntidad, SoftwareInstaladoEntidad> softwaresInstalados;
    public static volatile SingularAttribute<ComputadoraEntidad, Long> id;
    public static volatile ListAttribute<ComputadoraEntidad, ApartadoEntidad> estudiantes;
    public static volatile SingularAttribute<ComputadoraEntidad, Integer> noMaquina;
    public static volatile SingularAttribute<ComputadoraEntidad, String> direccionIP;

}