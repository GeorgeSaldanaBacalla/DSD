/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import pe.com.entidad.Horario;
import pe.com.soappet.service.HorarioDoctor;
import pe.com.soappet.service.Mascota;
import pe.com.soappet.service.MyException;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "mascotaManaged")
@ViewScoped
public class MascotaManaged implements Serializable {

    private Mascota mascota = new Mascota();
    private int idCliente;
    private List<Mascota> listaMascota = new ArrayList<>();

    @PostConstruct
    public void init() {
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Integer id = (Integer) s.getAttribute("idCliente");
        s.removeAttribute("idCliente");
        if (id != null) {
            idCliente = id;
            listarMascotas();
        }
    }

    public void listarMascotas() {
        try {
            pe.com.soappet.service.MascotaWS_Service service = new pe.com.soappet.service.MascotaWS_Service();
            pe.com.soappet.service.MascotaWS port = service.getMascotaWSPort();
            listaMascota = port.obtenerListadoMascotas(idCliente);
        } catch (MyException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void guardarMascota() {
        try {
            pe.com.soappet.service.MascotaWS_Service service = new pe.com.soappet.service.MascotaWS_Service();
            pe.com.soappet.service.MascotaWS port = service.getMascotaWSPort();
            mascota.setIdcliente(idCliente);
            mascota = port.guardarMascota(mascota);
            listarMascotas();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró satisfactoriamente", null));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void eliminarMascota(int id) {
        try {
            pe.com.soappet.service.MascotaWS_Service service = new pe.com.soappet.service.MascotaWS_Service();
            pe.com.soappet.service.MascotaWS port = service.getMascotaWSPort();
            port.eliminarMascota(id);
            listarMascotas();
        } catch (MyException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    /**
     * @return the mascota
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * @param mascota the mascota to set
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the listaMascota
     */
    public List<Mascota> getListaMascota() {
        return listaMascota;
    }

    /**
     * @param listaMascota the listaMascota to set
     */
    public void setListaMascota(List<Mascota> listaMascota) {
        this.listaMascota = listaMascota;
    }

}
