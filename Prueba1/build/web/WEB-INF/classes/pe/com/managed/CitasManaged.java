/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.managed;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pe.com.entidad.Cita;
import pe.com.entidad.Cliente;
import pe.com.entidad.ClienteMascota;
import pe.com.entidad.Disponibilidad;
import pe.com.entidad.Horario;
import pe.com.entidad.HorarioDisponibilidad;
import pe.com.entidad.Mascota;
import pe.com.soappet.business.CitasBusiness;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "citasManaged")
@ViewScoped
public class CitasManaged {

    private List<Cliente> listCliente = new ArrayList<>();
    private List<Mascota> listMascota = new ArrayList<>();
    private String dni;
    private Cliente cliente = new Cliente();
    private int idMascota;
    private ClienteMascota cm = new ClienteMascota();
    private boolean mostrarRegistrarCliente = false;
    private boolean mostrarRegistrarMascota = false;
    private int idDoctor;
    private Date diaCita;
    private Horario horarioDoctor = new Horario();
    private List<Disponibilidad> listaDisponibilidad = new ArrayList<Disponibilidad>();
    private boolean noExisteHorario;

    /**
     * Creates a new instance of CitasManaged
     */
    public CitasManaged() {
        
    }

    public void registrarMascota(){
        try {
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            s.setAttribute("idCliente", cliente.getIdcliente());
            FacesContext.getCurrentInstance().getExternalContext().redirect("mascotas.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }
    public void registrarCliente(){
        try {
            HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            s.setAttribute("dniClienteaCrear", dni);
            FacesContext.getCurrentInstance().getExternalContext().redirect("clienteForm.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }
    
    // ajax
    public void buscarCliente() {
        try {
            System.out.println("entro**********************");
            mostrarRegistrarCliente = false;
            mostrarRegistrarMascota = false;
            if (dni == null || dni.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrese un dni", null));
                return;
            }
            try {
                Integer.parseInt(dni);
            } catch (Exception e) {
                throw new Exception("El DNI solo debe contener numeros");
            }
            cm = new CitasBusiness().obtenerClienteMascota(dni);
            if (cm.getCliente() != null) {
                cliente = cm.getCliente();
                System.out.println("dni:" + cliente.getDni());
                if (cm.getListaMascotas().isEmpty()) {
                    listMascota = new ArrayList<>();
                    System.out.println("lista:" + listMascota.size());
                    mostrarRegistrarMascota = true;
                } else {
                    listMascota = cm.getListaMascotas();
                }
            } else {
                cliente = new Cliente();
                listMascota = new ArrayList<>();
                mostrarRegistrarCliente = true;
                mostrarRegistrarMascota = false;
            }
            System.out.println("salio**********************");
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void buscarDisponibilidad() {
        try {
            noExisteHorario = false;
            horarioDoctor = new Horario();
            listaDisponibilidad = new ArrayList<>();
            HorarioDisponibilidad hd = new CitasBusiness().obtenerDisponibilidad(String.valueOf(idDoctor), diaCita);
            horarioDoctor = hd.getHorario();
            System.out.println(horarioDoctor);
            if (horarioDoctor.getFechaEntrada() == null) {
                noExisteHorario = true;
                return;
            }
            listaDisponibilidad = hd.getDisponibilidad();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage("msgDisponibilidad", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void registrarCita() {
        try {
            Calendar cal = Calendar.getInstance();

            Date date = new Date();
            int i = 0;
            for (Disponibilidad d : listaDisponibilidad) {
                if (d.isSelect()) {
                    cal.setTime(d.getHora());
                    date = cal.getTime();
                    i++;
                }
            }
            if (i == 0) {
                FacesContext.getCurrentInstance().addMessage("messages",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Se debe seleccionar una hora para la cita",
                                null));
            }
            Cita cita = new Cita();
            cita.setIddoctor(idDoctor);
            cita.setIdmascota(idMascota);
            cita.setFechaCita(date);

            cita = new CitasBusiness().registrarCita(cita);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

            String mensaje = "Se registro correctamente la cita N° " + cita.getIdCita() + " para el día "
                    + sdf.format(cita.getFechaCita());
            FacesContext.getCurrentInstance().addMessage("messages",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null));
            buscarDisponibilidad();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage("messages",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    /**
     * @return the listCliente
     */
    public List<Cliente> getListCliente() {
        return listCliente;
    }

    /**
     * @param listCliente the listCliente to set
     */
    public void setListCliente(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }

    /**
     * @return the listMascota
     */
    public List<Mascota> getListMascota() {
        return listMascota;
    }

    /**
     * @param listMascota the listMascota to set
     */
    public void setListMascota(List<Mascota> listMascota) {
        this.listMascota = listMascota;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
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
     * @return the mostrarRegistrarCliente
     */
    public boolean isMostrarRegistrarCliente() {
        return mostrarRegistrarCliente;
    }

    /**
     * @param mostrarRegistrarCliente the mostrarRegistrarCliente to set
     */
    public void setMostrarRegistrarCliente(boolean mostrarRegistrarCliente) {
        this.mostrarRegistrarCliente = mostrarRegistrarCliente;
    }

    /**
     * @return the mostrarRegistrarMascota
     */
    public boolean isMostrarRegistrarMascota() {
        return mostrarRegistrarMascota;
    }

    /**
     * @param mostrarRegistrarMascota the mostrarRegistrarMascota to set
     */
    public void setMostrarRegistrarMascota(boolean mostrarRegistrarMascota) {
        this.mostrarRegistrarMascota = mostrarRegistrarMascota;
    }

    /**
     * @return the idMascota
     */
    public int getIdMascota() {
        return idMascota;
    }

    /**
     * @param idMascota the idMascota to set
     */
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    /**
     * @return the idDoctor
     */
    public int getIdDoctor() {
        return idDoctor;
    }

    /**
     * @param idDoctor the idDoctor to set
     */
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    /**
     * @return the diaCita
     */
    public Date getDiaCita() {
        return diaCita;
    }

    /**
     * @param diaCita the diaCita to set
     */
    public void setDiaCita(Date diaCita) {
        this.diaCita = diaCita;
    }

    /**
     * @return the horarioDoctor
     */
    public Horario getHorarioDoctor() {
        return horarioDoctor;
    }

    /**
     * @param horarioDoctor the horarioDoctor to set
     */
    public void setHorarioDoctor(Horario horarioDoctor) {
        this.horarioDoctor = horarioDoctor;
    }

    /**
     * @return the listaDisponibilidad
     */
    public List<Disponibilidad> getListaDisponibilidad() {
        return listaDisponibilidad;
    }

    /**
     * @param listaDisponibilidad the listaDisponibilidad to set
     */
    public void setListaDisponibilidad(List<Disponibilidad> listaDisponibilidad) {
        this.listaDisponibilidad = listaDisponibilidad;
    }

    /**
     * @return the noExisteHorario
     */
    public boolean isNoExisteHorario() {
        return noExisteHorario;
    }

    /**
     * @param noExisteHorario the noExisteHorario to set
     */
    public void setNoExisteHorario(boolean noExisteHorario) {
        this.noExisteHorario = noExisteHorario;
    }
}
