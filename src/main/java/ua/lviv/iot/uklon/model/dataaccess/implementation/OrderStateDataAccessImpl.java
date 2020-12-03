package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.entity.OrderState;

public class OrderStateDataAccessImpl extends AbstractDataAccess<OrderState> {

    public OrderStateDataAccessImpl() {
        super(OrderState.class);
    }
}
