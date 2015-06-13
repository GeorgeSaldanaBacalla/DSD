/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import pe.com.soappet.dao.CitaDAO;
import pe.com.soappet.dominio.Cita;
import pe.com.soappet.dominio.ClienteMascota;
import pe.com.soappet.dominio.Disponibilidad;
import pe.com.soappet.dominio.Horario;
import pe.com.soappet.dominio.HorarioDisponibilidad;
import pe.com.soappet.dominio.MyCitaException;
import pe.com.soappet.dominio.MyCitaExceptionBean;

/**
 *
 * @author Administrador
 */
@Path("/Citas")
public class Citas {

    @GET
    @Path("/cliente/{dni}")
    @Produces("application/json")
    public ClienteMascota obtenerClienteMascota(@PathParam(value = "dni") String dni) throws MyCitaException {
        try {
            pe.com.soappet.service.ClienteWS_Service clienteService = new pe.com.soappet.service.ClienteWS_Service();
            pe.com.soappet.service.ClienteWS clientePort = clienteService.getClienteWSPort();
            Cliente cli = null;
            try {
                cli = clientePort.obtenerCliente(dni);
            } catch (Exception e) {
                System.out.println("entro a la exceptionnnnnnnnnnnnnn");
            }
            List<Mascota> listaMascota = new ArrayList<>();
            if (cli != null) {
                pe.com.soappet.service.MascotaWS_Service mascotaService = new pe.com.soappet.service.MascotaWS_Service();
                pe.com.soappet.service.MascotaWS mascotaPort = mascotaService.getMascotaWSPort();
                listaMascota = mascotaPort.obtenerListadoMascotas(cli.getIdcliente());
            }
            ClienteMascota cm = new ClienteMascota();
            cm.setCliente(cli);
            cm.setListaMascotas(listaMascota);

            return cm;
        } catch (Exception ex) {
            throw new MyCitaException("error soappet", new MyCitaExceptionBean(ex.getMessage()));
        }
    }

    @POST
    @Path("/disponibilidad")
    @Produces("application/json")
    public HorarioDisponibilidad obtenerDisponibilidadDoctor(Disponibilidad d) throws MyCitaException {
        try {
            Date fechaCita = d.getHora();
            String idDoc = d.getIdDoctor();

            int idDoctor = Integer.parseInt(idDoc);

            GregorianCalendar c = new GregorianCalendar();
            c.setTime(fechaCita);
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

            pe.com.soappet.service.HorarioWS_Service service = new pe.com.soappet.service.HorarioWS_Service();
            pe.com.soappet.service.HorarioWS port = service.getHorarioWSPort();
            List<HorarioDoctor> lista = port.obtenerHorario(idDoctor, date2);

            if (lista == null) {
                throw new Exception("no existe horario para esa fecha");
            }

            List<Horario> listaHorario = new ArrayList<>();

            for (HorarioDoctor l : lista) {
                Horario h = new Horario();
                h.setId(l.getId());
                h.setIdDoctor(l.getIdDoctor());
                h.setFechaEntrada(l.getFechaEntrada().toGregorianCalendar().getTime());
                h.setFechaSalida(l.getFechaSalida().toGregorianCalendar().getTime());
                listaHorario.add(h);
            }

            List<Cita> listaCitas = obtenerCitas(idDoctor, fechaCita);

            List<Disponibilidad> listaDispo = new ArrayList<>();

            Disponibilidad dis = null;

            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaCita);
            cal.set(Calendar.HOUR_OF_DAY, 8);
            cal.set(Calendar.MINUTE, 0);
            Date aux = cal.getTime();

            cal.setTime(fechaCita);
            cal.set(Calendar.HOUR_OF_DAY, 20);
            cal.set(Calendar.MINUTE, 0);
            Date tope = cal.getTime();

            while (aux.before(tope)) {

                boolean agregar = true;
                for (Cita cita : listaCitas) {
                    cal.setTime(cita.getFechaCita());
                    int horaCita = cal.get(Calendar.HOUR_OF_DAY);
                    cal.setTime(aux);
                    int horaDisponibilidad = cal.get(Calendar.HOUR_OF_DAY);
                    if (horaCita == horaDisponibilidad) {
                        agregar = false;
                    }
                }

                if (agregar) {
                    dis = new Disponibilidad();
                    dis.setHora(aux);
                    dis.setIdDoctor(idDoc);
                    listaDispo.add(dis);
                }

                cal.setTime(aux);
                cal.add(Calendar.HOUR_OF_DAY, 1);
                aux = cal.getTime();
            }

            HorarioDisponibilidad hd = new HorarioDisponibilidad();
            if (!listaHorario.isEmpty()) {
                hd.setHorario(listaHorario.get(0));
            } else {
                hd.setHorario(new Horario());
            }
            hd.setDisponibilidad(listaDispo);
            return hd;
        } catch (Exception ex) {
            throw new MyCitaException("error soappet", new MyCitaExceptionBean(ex.getMessage()));
        }
    }
    
    @POST
    @Path("")
    @Produces("application/json")
    public Cita registrarCita(Cita cita) throws MyCitaException {
        try{
            CitaDAO dao = new CitaDAO();
            cita = dao.registrarCita(cita);
            //regitrar o actualizar historia clinica
             return cita;
        } catch(Exception e){
            throw new MyCitaException(e.getMessage(), new MyCitaExceptionBean());
        }
    }

    private List<Cita> obtenerCitas(int idDoctor, Date fecha) throws Exception {
        CitaDAO dao = new CitaDAO();
        List<Cita> lista = dao.obtenerCitas(idDoctor, fecha);
        return lista;
    }

}
