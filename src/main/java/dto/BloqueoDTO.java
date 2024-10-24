/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author Beto_
 */
public class BloqueoDTO {
    private String motivo;
    private LocalDate fecha;

    public BloqueoDTO() {
    }
    
    public BloqueoDTO(String motivo) {
        this.motivo = motivo;
        this.fecha = LocalDate.now();
    }

    public BloqueoDTO(String motivo, LocalDate fecha) {
        this.motivo = motivo;
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "BloqueoDTO{" + "motivo=" + motivo + ", fecha=" + fecha + '}';
    }
}
