package ua.lviv.iot.uklon.model.service.implementation;

import ua.lviv.iot.uklon.model.dataaccess.implementation.CreditCardDataAccessImpl;
import ua.lviv.iot.uklon.model.entity.CreditCard;

public class CreditCardServiceImpl extends AbstractService<CreditCard> {

    public CreditCardServiceImpl() {
        super(new CreditCardDataAccessImpl());
    }

}
