/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import enums.TipoComputadora;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "tblComputadora")
public class ComputadoraEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "contrasenaMaestra", nullable = false, length = 50)
    private String contrasenaMaestra;
    
    @Column(name = "estatus", nullable = false, length = 50)
    private String estatus;
    
    @Column(name = "direccionIP", nullable = false, length = 50)
    private String direccionIP;
    
    @Column(name = "noMaquina", nullable = false)
    private int noMaquina;
    
    @Enumerated(EnumType.STRING)
    private TipoComputadora tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_LaboratorioComputo")
    private LaboratorioComputoEntidad laboratorioComputo;
    
    @ManyToOne
    @JoinColumn(name = "id_Estudiante")
    private EstudianteEntidad estudiante;
    
    @OneToMany(mappedBy = "computadora", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<SoftwareInstaladoEntidad> softwaresInstalados;

    public ComputadoraEntidad() {
        this.estatus = "Disponible";
    }

    public ComputadoraEntidad(String contrasenaMaestra, String direccionIP, int noMaquina, TipoComputadora tipo) {
        this.contrasenaMaestra = contrasenaMaestra;
        this.direccionIP = direccionIP;
        this.noMaquina = noMaquina;
        this.tipo = tipo;
        this.estatus = "Disponible";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LaboratorioComputoEntidad getLaboratorioComputo() {
        return laboratorioComputo;
    }

    public void setLaboratorioComputo(LaboratorioComputoEntidad laboratorioComputo) {
        this.laboratorioComputo = laboratorioComputo;
    }

    public EstudianteEntidad getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntidad estudiante) {
        this.estudiante = estudiante;
    }

    public List<SoftwareInstaladoEntidad> getSoftwaresInstalados() {
        return softwaresInstalados;
    }

    public void setSoftwaresInstalados(List<SoftwareInstaladoEntidad> softwaresInstalados) {
        this.softwaresInstalados = softwaresInstalados;
    }

    @Override
    public String toString() {
        return "ComputadoraEntidad{" + "id=" + id + ", contrasenaMaestra=" + contrasenaMaestra + ", estatus=" + estatus + ", direccionIP=" + direccionIP + ", noMaquina=" + noMaquina + ", tipo=" + tipo + ", laboratorioComputo=" + laboratorioComputo + ", estudiante=" + estudiante + ", softwaresInstalados=" + softwaresInstalados + '}';
    }
}
