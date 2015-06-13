/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.com.soappet.dominio.Cliente;

/**
 *
 * @author Administrador
 */
public class ClienteDAO {

    public Cliente obtenerCliente(String dni) throws Exception {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();
        Cliente cli = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from Cliente as doc where doc.dni = :dni and doc.estado=1");
            q.setString("dni", dni);
            cli = (Cliente) q.list().get(0);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("El cliente no existe");
        } finally {
            sesion.close();
            //sf.close();
        }
        return cli;
    }

    public Cliente registrarCliente(Cliente cliente) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        Cliente cli = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(cliente);
            tx.commit();
            int lastId = ((BigInteger) sesion.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
            sesion.flush();
            cli = (Cliente) sesion.get(Cliente.class, lastId);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el cliente");
        } finally {
            sesion.close();
            //sf.close();
        }
        return cli;
    }

    public List<Cliente> listarClientes() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();
        List<Cliente> lista = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from Cliente as cli where cli.estado = 1");
            lista = (List<Cliente>) q.list();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            sesion.close();
            //sf.close();
        }
        return lista;
    }

    public void eliminarCliente(String dni) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx2 = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Cliente as doc where doc.dni = :dni");
            q.setString("dni", dni);
            Cliente cliente = (Cliente) q.list().get(0);

            tx2 = sesion.beginTransaction();
            cliente.setEstado(0);
            sesion.update(cliente);
            tx2.commit();

            sesion.flush();

        } catch (Exception e) {
            tx2.rollback();
            throw new RuntimeException("No se pudo guardar el cliente");
        } finally {
            sesion.close();
            //sf.close();
        }
    }
    
   
}
