package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.PassengerDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Passenger;

public class PassengerServiceImpl extends AbstractService<Passenger> {

  public PassengerServiceImpl() {
    super(new PassengerDataAccessImpl());
  }

}
