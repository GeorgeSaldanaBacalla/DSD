/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.service;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.com.soappet.dao.ClienteDAO;
import pe.com.soappet.dominio.Cliente;
import pe.com.soappet.dominio.MyException;
import pe.com.soappet.dominio.MyExceptionBean;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "ClienteWS")
public class ClienteWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerCliente")
    public Cliente obtenerCliente(@WebParam(name = "dni") String dni) throws MyException {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = null;
        try {
            cliente = dao.obtenerCliente(dni);
        } catch (Exception ex) {
            throw new MyException(ex.getMessage(), new MyExceptionBean());
        }

        return cliente;
    }

    @WebMethod(operationName = "guardarCliente")
    public Cliente guardarCliente(@WebParam(name = "cliente") Cliente cliente) throws MyException {
        ClienteDAO dao = new ClienteDAO();
        cliente.setEstado(1);
        cliente = dao.registrarCliente(cliente);
        return cliente;
    }
    
    @WebMethod(operationName = "eliminarCliente")
    public void eliminarDoctor(@WebParam(name = "dni") String dni) {
        ClienteDAO dao = new ClienteDAO();
        dao.eliminarCliente(dni);
    }
    
    @WebMethod(operationName = "listarClientes")
    public List<Cliente> listarDoctores() {
        ClienteDAO dao = new ClienteDAO();
        return dao.listarClientes();
    }
}
