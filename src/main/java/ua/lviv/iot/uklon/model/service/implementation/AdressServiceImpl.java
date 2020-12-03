package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.AdressDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Adress;

public class AdressServiceImpl extends AbstractService<Adress> {

    public AdressServiceImpl() {
        super(new AdressDataAccessImpl());
    }

}
