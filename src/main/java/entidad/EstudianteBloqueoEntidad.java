/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
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
@Table(name = "tblEstudiante_Bloqueo")
public class EstudianteBloqueoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private EstudianteEntidad estudiante;

    @ManyToOne
    @JoinColumn(name = "id_bloqueo")
    private BloqueoEntidad bloqueo;

    public EstudianteBloqueoEntidad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstudianteEntidad getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntidad estudiante) {
        this.estudiante = estudiante;
    }

    public BloqueoEntidad getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(BloqueoEntidad bloqueo) {
        this.bloqueo = bloqueo;
    }

    @Override
    public String toString() {
        return "EstudianteBloqueoEntidad{" + "id=" + id + ", estudiante=" + estudiante + ", bloqueo=" + bloqueo + '}';
    }
}
