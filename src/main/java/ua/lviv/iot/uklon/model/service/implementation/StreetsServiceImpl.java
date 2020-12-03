package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.StreetsDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Streets;

public class StreetsServiceImpl extends AbstractService<Streets> {

    public StreetsServiceImpl() {
        super(new StreetsDataAccessImpl());
    }

}
