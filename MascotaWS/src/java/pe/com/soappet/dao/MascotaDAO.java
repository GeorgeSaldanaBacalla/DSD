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
import pe.com.soappet.dominio.Mascota;

/**
 *
 * @author Administrador
 */
public class MascotaDAO {
    public List<Mascota> listadoMascota(int idCliente) throws Exception {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();
        List<Mascota> lista = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from Mascota as mas where mas.idcliente = :id and mas.estado=1");
            q.setInteger("id", idCliente);
            lista = (List<Mascota>) q.list();
          
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            sesion.close();
            //sf.close();
        }
        return lista;
    }
    
     public Mascota registrarMascota(Mascota mascota) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        Mascota mas = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(mascota);
            tx.commit();
            int lastId = ((BigInteger) sesion.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
            sesion.flush();
            mas = (Mascota) sesion.get(Mascota.class, lastId);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw new RuntimeException("No se pudo guardar la mascota");
        } finally {
            sesion.close();
            //sf.close();
        }
        return mas;
    }
     
      public void eliminarMascota(int id) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx2 = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();

            Query q = sesion.createQuery("from Mascota as doc where doc.idMascota = :id");
            q.setInteger("id", id);
            Mascota mascota = (Mascota) q.list().get(0);

            tx2 = sesion.beginTransaction();
            mascota.setEstado(0);
            sesion.update(mascota);
            tx2.commit();

            sesion.flush();

        } catch (Exception e) {
            tx2.rollback();
            throw new RuntimeException("No se pudo guardar la mascota");
        } finally {
            sesion.close();
            //sf.close();
        }
    }
      
      
}
