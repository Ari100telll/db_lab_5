package ua.lviv.iot.uklon.controller;

import java.sql.SQLException;
import java.util.List;

public interface Controller<E> {
  List<E> findAll();

  E findById(Integer id);

  E create(E entity);

  E update(Integer id, E entity);

  E delete(Integer id);
}
