package ua.lviv.iot.uklon.model.service;

import java.sql.SQLException;
import java.util.List;

public interface Service<E> {
  List<E> findAll();

  E findById(Integer id);

  E create(E entity);

  E update(Integer id, E entity);

  E delete(Integer id);
}