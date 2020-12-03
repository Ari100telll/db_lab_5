package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.CityDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.City;

public class CityServiceImpl extends AbstractService<City> {

    public CityServiceImpl() {
        super(new CityDataAccessImpl());
    }

}
