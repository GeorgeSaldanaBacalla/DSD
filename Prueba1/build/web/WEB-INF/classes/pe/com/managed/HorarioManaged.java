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
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import pe.com.entidad.Horario;
import pe.com.soappet.service.HorarioDoctor;
import pe.com.soappet.service.MyException;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "horarioManaged")
@ViewScoped
public class HorarioManaged implements Serializable {

    private Date dia;
    private Date horaInicio;
    private Date horaFin;
    private int idDoctor;
    private List<Horario> listaHorario = new ArrayList<>();

    public HorarioManaged() {
        Calendar c = Calendar.getInstance();
        dia = c.getTime();
        c.set(Calendar.HOUR_OF_DAY, 8);
        c.set(Calendar.MINUTE, 0);
        horaInicio = c.getTime();
        c.set(Calendar.HOUR_OF_DAY, 20);
        c.set(Calendar.MINUTE, 0);
        horaFin = c.getTime();
    }
    
    @PostConstruct
    public void init(){
        idDoctor  = 1;
        buscarHorario();
    }

    /**
     * @return the dia
     */
    public Date getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(Date dia) {
        this.dia = dia;
    }

    /**
     * @return the horaInicio
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public Date getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the listaHorario
     */
    public List<Horario> getListaHorario() {
        return listaHorario;
    }

    /**
     * @param listaHorario the listaHorario to set
     */
    public void setListaHorario(List<Horario> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public void registrar() {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(horaInicio);
            int hora = c.get(Calendar.HOUR_OF_DAY);
            int minuto = c.get(Calendar.MINUTE);
            c.setTime(dia);
            c.set(Calendar.HOUR_OF_DAY, hora);
            c.set(Calendar.MINUTE, minuto);

            GregorianCalendar ca = new GregorianCalendar();
            ca.setTime(c.getTime());
            XMLGregorianCalendar diaIni;
            diaIni = DatatypeFactory.newInstance().newXMLGregorianCalendar(ca);
            
            
            c.setTime(horaFin);
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);
            c.setTime(dia);
            c.set(Calendar.HOUR_OF_DAY, hora);
            c.set(Calendar.MINUTE, minuto);
            ca.setTime(c.getTime());
            XMLGregorianCalendar diaFin;
            diaFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(ca);

            System.out.println("diaIni: "+diaIni);
            System.out.println("diaFin: "+diaFin);
            
            pe.com.soappet.service.HorarioWS_Service service = new pe.com.soappet.service.HorarioWS_Service();
            pe.com.soappet.service.HorarioWS port = service.getHorarioWSPort();
            HorarioDoctor horario = port.registrarHorario(idDoctor, diaIni, diaFin);
            System.out.println("horario"+horario.getId());
            buscarHorario();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(HorarioManaged.class.getName()).log(Level.SEVERE, null, ex);
        } catch(MyException ex){
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void buscarHorario() {

        listaHorario = new ArrayList<>();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(dia);
        XMLGregorianCalendar date2;
        try {
            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

            pe.com.soappet.service.HorarioWS_Service service = new pe.com.soappet.service.HorarioWS_Service();
            pe.com.soappet.service.HorarioWS port = service.getHorarioWSPort();
            List<HorarioDoctor> lista = port.obtenerHorario(idDoctor, date2);
            System.out.println("size**************************:" + lista.size());
            for (HorarioDoctor l : lista) {
                Horario h = new Horario();
                h.setId(l.getId());
                h.setIdDoctor(l.getIdDoctor());
                h.setFechaEntrada(l.getFechaEntrada().toGregorianCalendar().getTime());
                System.out.println("fechaIni:" + h.getFechaEntrada());
                h.setFechaSalida(l.getFechaSalida().toGregorianCalendar().getTime());
                System.out.println("fechaIni:" + h.getFechaSalida());
                listaHorario.add(h);
            }

        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(HorarioManaged.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
