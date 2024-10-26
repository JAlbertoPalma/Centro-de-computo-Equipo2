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

    public BloqueoDTO() {
    }
    
    public BloqueoDTO(String motivo) {
        this.motivo = motivo;
    }

    public BloqueoDTO(String motivo, LocalDate fecha) {
        this.motivo = motivo;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "BloqueoDTO{" + "motivo=" + motivo + '}';
    }
}
