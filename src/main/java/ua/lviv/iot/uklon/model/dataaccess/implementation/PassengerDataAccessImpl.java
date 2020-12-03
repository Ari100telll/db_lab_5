package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.entity.Passenger;

public class PassengerDataAccessImpl extends AbstractDataAccess<Passenger> {

    public PassengerDataAccessImpl() {
        super(Passenger.class);
    }
}
