/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Beto_
 */
@Entity
@Table(name = "tblLaboratoriosComputo")
public class LaboratorioComputoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "horaInicio", columnDefinition = "TIME")
    private LocalTime horaInicio;
    
    @Column(name = "horaFin", columnDefinition = "TIME")
    private LocalTime horaFin;
    
    @ManyToOne
    @JoinColumn(name = "id_unidadAcademica")
    private UnidadAcademicaEntidad unidadAcademica;
    
    @OneToMany(mappedBy = "laboratorioComputo", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ComputadoraEntidad> computadoras;

    public LaboratorioComputoEntidad() {
    }

    public LaboratorioComputoEntidad(String nombre, LocalTime horaInicio, LocalTime horaFin, UnidadAcademicaEntidad unidadAcademica) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.unidadAcademica = unidadAcademica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public UnidadAcademicaEntidad getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademicaEntidad unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public List<ComputadoraEntidad> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<ComputadoraEntidad> computadoras) {
        this.computadoras = computadoras;
    }

    @Override
    public String toString() {
        return "LaboratorioComputoEntidad{" + "id=" + id + ", nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", unidadAcademica=" + unidadAcademica + ", computadoras=" + computadoras + '}';
    }
}
