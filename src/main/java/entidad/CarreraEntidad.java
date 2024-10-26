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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Beto_
 */
@Entity
@Table(name = "tblCarreras")
public class CarreraEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "tiempoLimite", columnDefinition = "TIME")
    private LocalTime tiempoLimite;
    
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<EstudianteEntidad> estudiante;

    public CarreraEntidad() {
    }

    public CarreraEntidad(String nombre, LocalTime tiempoLimite) {
        this.nombre = nombre;
        this.tiempoLimite = tiempoLimite;
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

    public LocalTime getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(LocalTime tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public List<EstudianteEntidad> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<EstudianteEntidad> estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "CarreraEntidad{" + "id=" + id + ", nombre=" + nombre + ", tiempoLimite=" + tiempoLimite + ", estudiante=" + estudiante + '}';
    }
}
