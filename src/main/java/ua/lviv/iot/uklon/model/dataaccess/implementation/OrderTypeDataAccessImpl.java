package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.entity.OrderType;

public class OrderTypeDataAccessImpl extends AbstractDataAccess<OrderType> {

    public OrderTypeDataAccessImpl() {
        super(OrderType.class);
    }
}
