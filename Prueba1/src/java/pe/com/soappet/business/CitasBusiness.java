/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.business;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import pe.com.entidad.Cita;
import pe.com.entidad.ClienteMascota;
import pe.com.entidad.HorarioDisponibilidad;

/**
 *
 * @author Administrador
 */
public class CitasBusiness {

    public ClienteMascota obtenerClienteMascota(String dni) throws Exception {
        try {
            ClientRequest request = new ClientRequest("http://localhost:8080/CitasREST/rest/Citas/cliente/" + dni);
            request.accept("application/json");
            ClientResponse<ClienteMascota> response = request.get(ClienteMascota.class);

            if (response.getStatus() != 200) {
                throw new Exception("error code: " + response.getStatus());
            }

            ClienteMascota cm = response.getEntity();

            /*System.out.println("cm: " + cm);
             System.out.println("cliente: " + cm.getCliente());
             System.out.println("cliente nombre: " + cm.getCliente().getNombre());
             System.out.println("cliente apellido: " + cm.getCliente().getApePaterno());
             System.out.println("lista Mascotas: " + cm.getListaMascotas().size());
             */
            return cm;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public HorarioDisponibilidad obtenerDisponibilidad(String idDoctor, Date fecha) throws Exception {
        try {
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(fecha);
            XMLGregorianCalendar date2;

            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

            ClientRequest request = new ClientRequest("http://localhost:8080/CitasREST/rest/Citas/disponibilidad");
            request.accept("application/json");
            //{"idDoctor":"1","hora":"2015-06-11T08:00:38.526-05:00"}
            String input = "{\"idDoctor\":\"" + idDoctor + "\",\"hora\":\"" + date2.toString() + "\"}";
            System.out.println(input);
            request.body("application/json", input);

            ClientResponse<HorarioDisponibilidad> response = request.post(HorarioDisponibilidad.class);

            if (response.getStatus() != 200) {
                throw new Exception("error code: " + response.getStatus());
            }

            HorarioDisponibilidad cm = response.getEntity();
            return cm;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Cita registrarCita(Cita cita) throws Exception {
        try {
            int idMascota = cita.getIdmascota();
            int idDoctor = cita.getIddoctor();
            Date fecha = cita.getFechaCita();

            GregorianCalendar c = new GregorianCalendar();
            c.setTime(fecha);
            XMLGregorianCalendar date2;

            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

            ClientRequest request = new ClientRequest("http://localhost:8080/CitasREST/rest/Citas");
            request.accept("application/json");
            //{"idmascota":"1","iddoctor":"1","fechaCita":"2015-06-13T09:00:00.526-05:00"}
            String input = "{\"idmascota\":\"" + idMascota + "\",\"iddoctor\":\"" + idDoctor + "\",\"fechaCita\":\"" + date2.toString() + "\"}";
            System.out.println(input);
            request.body("application/json", input);

            ClientResponse<Cita> response = request.post(Cita.class);

            if (response.getStatus() != 200) {
                throw new Exception("error code: " + response.getStatus());
            }

            Cita ci = response.getEntity();
            return ci;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
