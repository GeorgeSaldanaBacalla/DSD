/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.service;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.com.soappet.dao.HorarioDAO;
import pe.com.soappet.dominio.HorarioDoctor;
import pe.com.soappet.dominio.MyException;
import pe.com.soappet.dominio.MyExceptionBean;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "HorarioWS")
public class HorarioWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "RegistrarHorario")
    public HorarioDoctor RegistrarHorario(@WebParam(name = "idDoctor") int idDoctor, @WebParam(name = "fechaInicio") Date fechaInicio, @WebParam(name = "fechaFin") Date fechaFin) throws MyException{
        HorarioDoctor h = new HorarioDoctor();
        h.setIdDoctor(idDoctor);
        h.setFechaEntrada(fechaInicio);
        h.setFechaSalida(fechaFin);

        HorarioDAO dao = new HorarioDAO();

        List<HorarioDoctor> lista = dao.listarHorarios(fechaInicio, idDoctor);
        
        if (lista != null && !lista.isEmpty()) {
            throw new MyException("El horario ya ha sido registrado",new MyExceptionBean());
        }
        dao.registrarHorario(h);
        return h;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerHorario")
    public List<HorarioDoctor> obtenerHorario(@WebParam(name = "idDoctor") int idDoctor, @WebParam(name = "fecha") Date fecha) {

        HorarioDAO dao = new HorarioDAO();
        List<HorarioDoctor> lista = dao.listarHorarios(fecha, idDoctor);
        return lista;

    }
}
