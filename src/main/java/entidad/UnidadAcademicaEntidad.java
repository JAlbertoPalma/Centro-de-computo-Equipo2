/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Beto_
 */
@Entity
@Table(name = "tblUnidadAcademica")
public class UnidadAcademicaEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @OneToMany(mappedBy = "unidadAcademica", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<LaboratorioComputoEntidad> laboratoriosComputo;

    public UnidadAcademicaEntidad() {
        
    }

    public UnidadAcademicaEntidad(String nombre) {
        this.nombre = nombre;
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

    public List<LaboratorioComputoEntidad> getLaboratoriosComputo() {
        return laboratoriosComputo;
    }

    public void setLaboratoriosComputo(List<LaboratorioComputoEntidad> laboratoriosComputo) {
        this.laboratoriosComputo = laboratoriosComputo;
    }

    @Override
    public String toString() {
        return "UnidadAcademicaEntidad{" + "id=" + id + ", nombre=" + nombre + ", laboratoriosComputo=" + laboratoriosComputo + '}';
    }
}
