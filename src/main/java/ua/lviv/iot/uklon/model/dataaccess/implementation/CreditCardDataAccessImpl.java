package ua.lviv.iot.uklon.model.dataaccess.implementation;

import ua.lviv.iot.uklon.model.dataaccess.DataAccess;
import ua.lviv.iot.uklon.model.entity.CreditCard;

public class CreditCardDataAccessImpl extends AbstractDataAccess<CreditCard> {

    public CreditCardDataAccessImpl() {
        super(CreditCard.class);
    }
}
