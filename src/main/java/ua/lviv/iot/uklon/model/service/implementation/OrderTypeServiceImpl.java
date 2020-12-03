package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.OrderTypeDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.OrderType;

public class OrderTypeServiceImpl extends AbstractService<OrderType> {

  public OrderTypeServiceImpl() {
    super(new OrderTypeDataAccessImpl());
  }

}
