/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dominio;

import java.io.Serializable;
import java.util.List;
import pe.com.soappet.service.HorarioDoctor;

/**
 *
 * @author Administrador
 */
public class HorarioDisponibilidad implements Serializable{
    private Horario horario;
    private List<Disponibilidad> disponibilidad;

    /**
     * @return the horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * @return the disponibilidad
     */
    public List<Disponibilidad> getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * @param disponibilidad the disponibilidad to set
     */
    public void setDisponibilidad(List<Disponibilidad> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
