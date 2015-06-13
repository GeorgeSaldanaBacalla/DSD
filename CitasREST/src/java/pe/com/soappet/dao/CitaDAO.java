/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.soappet.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.com.soappet.dominio.Cita;

/**
 *
 * @author Administrador
 */
public class CitaDAO {
    
    public List<Cita> obtenerCitas(int idDoctor,Date fecha) throws Exception {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();
        List<Cita> lista = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from Cita as c where c.iddoctor = :id and date(fechaCita)=:fecha");
            q.setInteger("id", idDoctor);
            q.setDate("fecha", fecha);
            lista = (List<Cita>) q.list();
          
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            sesion.close();
            //sf.close();
        }
        return lista;
    }
    
     public Cita registrarCita(Cita cita) throws Exception {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        Cita ci = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(cita);
            tx.commit();
            int lastId = ((BigInteger) sesion.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
            sesion.flush();
            ci = (Cita) sesion.get(Cita.class, lastId);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw new Exception("No se pudo guardar la cita");
        } finally {
            sesion.close();
            //sf.close();
        }
        return ci;
    }
}
