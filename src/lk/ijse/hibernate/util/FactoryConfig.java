/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.util;

import lk.ijse.hibernate.entity.Program;
import lk.ijse.hibernate.entity.Registration;
import lk.ijse.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfig {
    private static FactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private FactoryConfig() {

        Configuration config = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Program.class).addAnnotatedClass(Registration.class);
        sessionFactory = config.buildSessionFactory();
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static FactoryConfig getInstance() {
        return factoryConfig == null ? factoryConfig = new FactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
