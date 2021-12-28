/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.dao.custom.Impl;

import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student entity) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t1 = session.beginTransaction();

        session.save(entity);
        System.out.println(entity.toString());

        t1.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t2 = session.beginTransaction();

        Student stu = session.get(Student.class, s);
        session.delete(stu);

        t2.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t3 = session.beginTransaction();

        session.update(entity);

        t3.commit();
        session.close();
        return true;
    }


    @Override
    public List<Student> findAll() {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t4 = session.beginTransaction();

        Query q1 = session.createQuery("FROM Student");
        List<Student> list = q1.list();

        t4.commit();
        session.close();
        return list;
    }

    @Override
    public Student get(String id) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction t5 = session.beginTransaction();
        Student s1 = session.get(Student.class, id);
        t5.commit();
        session.close();
        return s1;
    }


}