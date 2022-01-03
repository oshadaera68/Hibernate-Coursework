/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.dao.custom.Impl;

import lk.ijse.hibernate.entity.Registration;
import lk.ijse.hibernate.util.FactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean save(Registration entity) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Registration entity) {
        return false;
    }

    @Override
    public boolean delete(String o) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Registration get(String o) {
        return null;
    }
}
