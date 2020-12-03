package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.DriverDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Driver;

public class DriverServiceImpl extends AbstractService<Driver> {

    public DriverServiceImpl() {
        super(new DriverDataAccessImpl());
    }

}
