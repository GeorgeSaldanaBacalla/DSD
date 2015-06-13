/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Disponibilidad implements Serializable{
    private Date hora;
    private String idDoctor;
    private boolean select;

    /**
     * @return the hora
     */
    public Date getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * @return the permitido
     */
    public String getIdDoctor() {
        return idDoctor;
    }

    /**
     * @param permitido the permitido to set
     */
    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    /**
     * @return the select
     */
    public boolean isSelect() {
        return select;
    }

    /**
     * @param select the select to set
     */
    public void setSelect(boolean select) {
        this.select = select;
    }
}
