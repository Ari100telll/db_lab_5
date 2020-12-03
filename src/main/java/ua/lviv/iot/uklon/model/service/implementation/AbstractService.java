package ua.lviv.iot.uklon.model.service.implementation;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.service.Service;

public abstract class AbstractService<E> implements Service<E> {

    private DataAccess<E> dataAccess;

    public AbstractService(DataAccess<E> dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public List<E> findAll() {
        List<E> Entities = dataAccess.findAll();
        if (Entities.size() > 0) {
            return Entities;
        } else {
            return null;
        }
    }

    @Override
    public E findById(Integer id) {
        return dataAccess.findById(id);
    }

    @Override
    public E create(E entity) {
        dataAccess.create(entity);
        return entity;
    }

    @Override
    public E update(Integer id, E entity) {
        E oldEntity = findById(id);
        dataAccess.update(entity);
        return oldEntity;
    }

    @Override
    public E delete(Integer id) {
        E entity = findById(id);
        dataAccess.delete(id);
        return entity;
    }
}
