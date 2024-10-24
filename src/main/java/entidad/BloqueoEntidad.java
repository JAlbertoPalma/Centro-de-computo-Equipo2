/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Beto_
 */
@Entity
@Table(name = "tblBloqueo")
public class BloqueoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "motivo", nullable = false, length = 50)
    private String motivo;
    
    @Column(name = "fecha", columnDefinition = "TIME")
    private LocalDate fecha;
    
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private EstudianteEntidad estudiante;

    public BloqueoEntidad() {
    }
    
    public BloqueoEntidad(String motivo) {
        this.motivo = motivo;
        this.fecha = LocalDate.now();
    }

    public BloqueoEntidad(String motivo, LocalDate fecha) {
        this.motivo = motivo;
        this.fecha = fecha;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstudianteEntidad getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntidad estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "BloqueoEntidad{" + "id=" + id + ", motivo=" + motivo + ", fecha=" + fecha + ", estudiante=" + estudiante + '}';
    }
}
