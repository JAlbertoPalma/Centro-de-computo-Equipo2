/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Beto_
 */
public class ApartadoDTO {
    private Long id;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long segundosActividad;

    public ApartadoDTO() {
    }

    public ApartadoDTO(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public ApartadoDTO(LocalTime horaInicio, LocalTime horaFin, Long segundosActividad) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.segundosActividad = segundosActividad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getSegundosActividad() {
        return segundosActividad;
    }

    public void setSegundosActividad(Long segundosActividad) {
        this.segundosActividad = segundosActividad;
    }

    @Override
    public String toString() {
        return "ApartadoDTO{" + "id=" + id + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", segundosActividad=" + segundosActividad + '}';
    }
}
