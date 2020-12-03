package ua.lviv.iot.uklon.model.dataaccess.implementation;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import ua.lviv.iot.uklon.model.connectors.ConnectionManager;
import ua.lviv.iot.uklon.model.dataaccess.DataAccess;

public abstract class AbstractDataAccess<E> implements DataAccess<E> {

    private final Class<E> clazz;
    private final ConnectionManager connectionManager;

    public AbstractDataAccess(Class<E> clazz) {
        this.clazz = clazz;
        this.connectionManager = new ConnectionManager();
    }

    @Override
    public List<E> findAll() {

        List<E> entityList;

        try (connectionManager) {
            Session session = connectionManager.openSession();
            entityList = session.createQuery("from " + clazz.getName()).getResultList();
        }
        return entityList;

    }

    @Override
    public E findById(Integer id) {
        E entity;

        try (connectionManager) {
            entity = connectionManager.openSession().get(clazz, (Serializable) id);
        }

        return entity;
    }

    @Override
    public int create(E entity) {
        try (connectionManager) {
            Session currentSession = connectionManager.openSessionWithTransaction();
            currentSession.saveOrUpdate(entity);
            connectionManager.commit();
        }
        return 0;
    }

    @Override
    public int update(E entity) {
        try (connectionManager) {
            connectionManager.openSessionWithTransaction().merge(entity);
            connectionManager.commit();
        }

        return 0;
    }

    @Override
    public int delete(Integer id) {
        try (connectionManager) {
            E entity = findById(id);
            Session currentSession = connectionManager.openSessionWithTransaction();
            currentSession.delete(entity);
            connectionManager.commit();
        }

        return 0;
    }
}
