/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalTime;

/**
 *
 * @author Beto_
 */
public class CarreraDTO {
    private String nombre;
    private LocalTime tiempoLimite;

    public CarreraDTO() {
    }

    public CarreraDTO(String nombre, LocalTime tiempoLimite) {
        this.nombre = nombre;
        this.tiempoLimite = tiempoLimite;
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

    @Override
    public String toString() {
        return "CarreraDTO{" + "nombre=" + nombre + ", tiempoLimite=" + tiempoLimite + '}';
    }
}
