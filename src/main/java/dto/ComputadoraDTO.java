/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import enums.TipoComputadora;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Beto_
 */
public class ComputadoraDTO {
    private String contrasenaMaestra;
    private String estatus;
    private String direccionIP;
    private int noMaquina;
    private TipoComputadora tipo;

    public ComputadoraDTO() {
    }

    public ComputadoraDTO(String contrasenaMaestra, String estatus, String direccionIP, int noMaquina, TipoComputadora tipo) {
        this.contrasenaMaestra = contrasenaMaestra;
        this.estatus = estatus;
        this.direccionIP = direccionIP;
        this.noMaquina = noMaquina;
        this.tipo = tipo;
    }

    public String getContrasenaMaestra() {
        return contrasenaMaestra;
    }

    public void setContrasenaMaestra(String contrasenaMaestra) {
        this.contrasenaMaestra = contrasenaMaestra;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public int getNoMaquina() {
        return noMaquina;
    }

    public void setNoMaquina(int noMaquina) {
        this.noMaquina = noMaquina;
    }

    public TipoComputadora getTipo() {
        return tipo;
    }

    public void setTipo(TipoComputadora tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ComputadoraDTO{" + "contrasenaMaestra=" + contrasenaMaestra + ", estatus=" + estatus + ", direccionIP=" + direccionIP + ", noMaquina=" + noMaquina + ", tipo=" + tipo + '}';
    }
}
