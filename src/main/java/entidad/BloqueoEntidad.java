/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "tblBloqueos")
public class BloqueoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "motivo", nullable = false, length = 50)
    private String motivo;
    
    
    @OneToMany(mappedBy = "bloqueo")
    private List<EstudianteBloqueoEntidad> estudiantes = new ArrayList<>();

    public BloqueoEntidad() {
    }
    
    public BloqueoEntidad(String motivo) {
        this.motivo = motivo;
    }

    public BloqueoEntidad(String motivo, LocalDate fecha) {
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public List<EstudianteBloqueoEntidad> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteBloqueoEntidad> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "BloqueoEntidad{" + "id=" + id + ", motivo=" + motivo + ", estudiantes=" + estudiantes + '}';
    }
}
