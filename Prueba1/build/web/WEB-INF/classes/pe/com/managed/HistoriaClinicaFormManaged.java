/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.managed;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "historiaClinicaForm")
@ViewScoped
public class HistoriaClinicaFormManaged {

    /**
     * Creates a new instance of HistoriaClinicaManaged
     */
    public HistoriaClinicaFormManaged() {
    }
    
    public void guardarHistoria(){
        String mensaje = "Se guardaron los datos correctamente";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null));
    }
}
