/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.managed;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pe.com.soappet.service.Cliente;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "listadoClientesManaged")
@ViewScoped
public class ListadoClientesManaged implements Serializable {

    private List<Cliente> listaClientes = new ArrayList<>();

    @PostConstruct
    public void init() {
        //listarClientees();
    }

    public ListadoClientesManaged() {
        listarClientes();
    }

    /**
     * @return the listaClientes
     */
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * @param listaClientes the listaClientees to set
     */
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void registrarMascota(int idCliente){
        try {
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            s.setAttribute("idCliente", idCliente);
            FacesContext.getCurrentInstance().getExternalContext().redirect("mascotas.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ListadoClientesManaged.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarClientes() {
        pe.com.soappet.service.ClienteWS_Service service = new pe.com.soappet.service.ClienteWS_Service();
        pe.com.soappet.service.ClienteWS port = service.getClienteWSPort();
        listaClientes = port.listarClientes();
    }

    public void eliminar(String dni) {
        eliminarCliente(dni);
        String mensaje = "Se eliminó correctamente";
        listarClientes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null));
    }

    private void eliminarCliente(String dni) {
        pe.com.soappet.service.ClienteWS_Service service = new pe.com.soappet.service.ClienteWS_Service();
        pe.com.soappet.service.ClienteWS port = service.getClienteWSPort();
        port.eliminarCliente(dni);
    }

    public void editar(String dni) {
        try {
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            s.setAttribute("dniCliente", dni);
            FacesContext.getCurrentInstance().getExternalContext().redirect("clienteForm.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ListadoClientesManaged.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
