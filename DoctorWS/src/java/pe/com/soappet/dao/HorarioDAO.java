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
import pe.com.soappet.dominio.HorarioDoctor;

/**
 *
 * @author Administrador
 */
public class HorarioDAO {
    public HorarioDoctor registrarHorario(HorarioDoctor horario) {
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        HorarioDoctor doc = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(horario);
            tx.commit();
            int lastId = ((BigInteger) sesion.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
            sesion.flush();
            doc = (HorarioDoctor) sesion.get(HorarioDoctor.class,lastId);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el horario");
        } finally {
            sesion.close();
            //sf.close();
        }
        return doc;
    }
    
    
    
    public List<HorarioDoctor> listarHorarios(Date dia, int idDoctor) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();
        List<HorarioDoctor> lista = new ArrayList<>();
        try {
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            Query q = sesion.createQuery("from HorarioDoctor as doc where doc.idDoctor = :id and date(doc.fechaEntrada)=:date");
            q.setInteger("id", idDoctor);
            q.setDate("date", dia);
            lista = (List<HorarioDoctor>) q.list();
          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            sesion.close();
            //sf.close();
        }
        return lista;
    }
    
    
}
