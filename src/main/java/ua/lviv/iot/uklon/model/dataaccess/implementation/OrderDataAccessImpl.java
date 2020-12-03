package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.entity.Order;

public class OrderDataAccessImpl extends AbstractDataAccess<Order> {

    public OrderDataAccessImpl() {
        super(Order.class);
    }
}
