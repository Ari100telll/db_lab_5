package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.VehicleDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Vehicle;

public class VehicleServiceImpl extends AbstractService<Vehicle> {

    public VehicleServiceImpl() {
        super(new VehicleDataAccessImpl());
    }

}
