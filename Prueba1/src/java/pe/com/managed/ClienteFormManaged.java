/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.managed;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pe.com.soappet.service.Cliente;
import pe.com.soappet.service.MyException;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "clienteForm")
@ViewScoped
public class ClienteFormManaged implements Serializable{

    private Cliente cliente = new Cliente();
    private boolean mostrarDni = false;
   
    @PostConstruct
    public void init() {
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String dni = (String)s.getAttribute("dniCliente");
        String dniClienteaCrear = (String)s.getAttribute("dniClienteaCrear");
        s.removeAttribute("dniCliente");
        if (dni != null) {
            mostrarDni = true;
            ver(dni);
        } else{
            mostrarDni = false;
            
            if(dniClienteaCrear != null){
                cliente.setDni(dniClienteaCrear);
            }
        }
    }

    public String guardarCliente() {
        try {
            pe.com.soappet.service.ClienteWS_Service service = new pe.com.soappet.service.ClienteWS_Service();
            pe.com.soappet.service.ClienteWS port = service.getClienteWSPort();
            port.guardarCliente(cliente);
            String mensaje = "Se guardaron los datos correctamente";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null));
            
        } catch (MyException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
            
        }
        return null;
    }

    private void ver(String dni) {
        try {
            cliente = obtenerCliente(dni);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }

    }

    private Cliente obtenerCliente(String dni) throws Exception {

        try {
            pe.com.soappet.service.ClienteWS_Service service = new pe.com.soappet.service.ClienteWS_Service();
            pe.com.soappet.service.ClienteWS port = service.getClienteWSPort();
            return port.obtenerCliente(dni);
        } catch (MyException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the mostrarDni
     */
    public boolean isMostrarDni() {
        return mostrarDni;
    }

    /**
     * @param mostrarDni the mostrarDni to set
     */
    public void setMostrarDni(boolean mostrarDni) {
        this.mostrarDni = mostrarDni;
    }

}
