/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.dao.custom.Impl;

import lk.ijse.hibernate.entity.Program;
import lk.ijse.hibernate.util.FactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean save(Program entity) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.save(entity);
        System.out.println(entity.toString());
        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Program entity) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t2 = session.beginTransaction();

        session.update(entity);

        t2.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t3 = session.beginTransaction();

        Program pro = session.get(Program.class, id);
        session.delete(pro);

        t3.commit();
        session.close();
        return true;
    }

    @Override
    public Program get(String id) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t5 = session.beginTransaction();
        Program s1 = session.get(Program.class, id);
        t5.commit();
        session.close();
        return s1;
    }

    @Override
    public List<Program> findAll() {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t4 = session.beginTransaction();

        Query q1 = session.createQuery("FROM Program");
        List<Program> list = q1.list();

        t4.commit();
        session.close();
        return list;
    }
}