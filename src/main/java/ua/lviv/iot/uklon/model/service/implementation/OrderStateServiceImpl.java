package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.OrderStateDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.OrderState;

public class OrderStateServiceImpl extends AbstractService<OrderState> {

    public OrderStateServiceImpl() {
        super(new OrderStateDataAccessImpl());
    }

}
