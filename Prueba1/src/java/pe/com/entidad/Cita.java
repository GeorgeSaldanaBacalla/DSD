/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.entidad;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Cita implements Serializable {

    private int idCita;
    private Integer idmascota;
    private Integer iddoctor;
    private Date fechaCita;

    /**
     * @return the idCita
     */
    public int getIdCita() {
        return idCita;
    }

    /**
     * @param idCita the idCita to set
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    /**
     * @return the idmascota
     */
    public Integer getIdmascota() {
        return idmascota;
    }

    /**
     * @param idmascota the idmascota to set
     */
    public void setIdmascota(Integer idmascota) {
        this.idmascota = idmascota;
    }

    /**
     * @return the iddoctor
     */
    public Integer getIddoctor() {
        return iddoctor;
    }

    /**
     * @param iddoctor the iddoctor to set
     */
    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    /**
     * @return the fechaCita
     */
    public Date getFechaCita() {
        return fechaCita;
    }

    /**
     * @param fechaCita the fechaCita to set
     */
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }
}
