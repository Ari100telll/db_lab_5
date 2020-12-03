package ua.lviv.iot.uklon.model.connectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager implements AutoCloseable {

    private SessionFactory ourSessionFactory;
    private Session session;
    private Transaction transaction;

    public ConnectionManager() {
        session = null;
        transaction = null;
    }

    public SessionFactory getSession(){
        SessionFactory ourSessionFactory;
        try { // Create the SessionFactory from hibernate.cfg.xml
            ourSessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
        return ourSessionFactory;
    }

    public Session openSession() {
        session = this.getSession().openSession();
        return session;
    }

    public Session openSessionWithTransaction() {
        session = this.getSession().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public boolean commit() {
        if (transaction != null) {
            transaction.commit();
            transaction = null;
            return true;
        }
        return false;
    }

    @Override
    public void close() {
        try {
            if (transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
