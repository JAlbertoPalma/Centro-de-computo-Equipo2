/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "tblEstudiantes")
public class EstudianteEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    
    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", nullable = false, length = 50)
    private String apellidoMaterno;
    
    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;
    
    @Column(name = "estaInscrito", nullable = false)
    private boolean estaInscrito;
    
    @Column(name = "estaBloqueado", nullable = false)
    private boolean estaBloqueado;
    
    @OneToMany(mappedBy = "estudiante")
    private List<ApartadoEntidad> computadoras = new ArrayList<>();
    
    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteBloqueoEntidad> bloqueos = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "id_Carrera")
    private CarreraEntidad carrera;

    public EstudianteEntidad() {
        this.estaInscrito = true;
        this.estaBloqueado = false;
    }

    public EstudianteEntidad(String nombres, String apellidoPaterno, String apellidoMaterno, String contrasena, CarreraEntidad carrera) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.carrera = carrera;
        this.estaInscrito = true;
        this.estaBloqueado = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstaInscrito() {
        return estaInscrito;
    }

    public void setEstaInscrito(boolean estaInscrito) {
        this.estaInscrito = estaInscrito;
    }

    public boolean isEstaBloqueado() {
        return estaBloqueado;
    }

    public void setEstaBloqueado(boolean estaBloqueado) {
        this.estaBloqueado = estaBloqueado;
    }

    public List<ApartadoEntidad> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<ApartadoEntidad> computadoras) {
        this.computadoras = computadoras;
    }

    public List<EstudianteBloqueoEntidad> getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(List<EstudianteBloqueoEntidad> bloqueos) {
        this.bloqueos = bloqueos;
    }
    
    public CarreraEntidad getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraEntidad carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "EstudianteEntidad{" + "id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", contrasena=" + contrasena + ", estaInscrito=" + estaInscrito + ", estaBloqueado=" + estaBloqueado + ", computadoras=" + computadoras + ", bloqueos=" + bloqueos + ", carrera=" + carrera + '}';
    }
}
