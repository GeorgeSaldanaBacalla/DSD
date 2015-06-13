/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.service;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.com.soappet.dao.MascotaDAO;
import pe.com.soappet.dominio.Mascota;
import pe.com.soappet.dominio.MyException;
import pe.com.soappet.dominio.MyExceptionBean;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "MascotaWS")
public class MascotaWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerListadoMascotas")
    public List<Mascota> obtenerListadoMascotas(@WebParam(name = "idCliente") int idCliente) throws MyException{
        MascotaDAO dao = new MascotaDAO();
        List<Mascota> lista = new ArrayList<>();
        try {
            lista = dao.listadoMascota(idCliente);
            if(lista == null ){
                lista = new ArrayList<>();
            }
        } catch (Exception ex) {
            throw new MyException("soappet error",new MyExceptionBean(ex.getMessage()));
        }
        return lista;
    }
    
   @WebMethod(operationName = "guardarMascota")
    public Mascota guardarMascota(@WebParam(name = "mascota") Mascota mascota) throws MyException{
        MascotaDAO dao = new MascotaDAO();
        mascota.setEstado(1);
        mascota = dao.registrarMascota(mascota);
        return mascota;
    }
    
    @WebMethod(operationName = "eliminarMascota")
    public void eliminarMascota(@WebParam(name = "id") int id) throws MyException{
        MascotaDAO dao = new MascotaDAO();
        dao.eliminarMascota(id);
    }
}
