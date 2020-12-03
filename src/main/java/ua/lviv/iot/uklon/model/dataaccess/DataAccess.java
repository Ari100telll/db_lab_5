package ua.lviv.iot.uklon.model.dataaccess;

import java.sql.SQLException;
import java.util.List;

public interface DataAccess<E>{
  
  List<E> findAll();
  
  E findById(Integer id);
  
  int create(E entity);

  int update(E entity);

  int delete(Integer id);
}
  
