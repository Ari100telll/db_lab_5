package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.entity.Vehicle;

public class VehicleDataAccessImpl extends AbstractDataAccess<Vehicle> {

    public VehicleDataAccessImpl() {
        super(Vehicle.class);
    }
}
