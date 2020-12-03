package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.OrderDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.Order;

public class OrderServiceImpl extends AbstractService<Order> {

    public OrderServiceImpl() {
        super(new OrderDataAccessImpl());
    }

}
