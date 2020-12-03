package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.entity.Passenger;
import ua.lviv.iot.uklon.model.entity.Passenger;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.CreditCardServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.PassengerServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class PassengerControllerImpl extends AbstractController<Passenger> {

    public PassengerControllerImpl() {
        super(new PassengerServiceImpl());
    }

    private static final List<String> COLUMNS_NAMES = List.of("id", "name", "surname",
            "tel_num", "credit_card_id", "rate");

    @Override
    public List<Passenger> findAll() {
        List<Passenger> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (Passenger address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public Passenger findById(Integer id) {
        Passenger address = super.findById(id);
        if (address != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            body.add(entityToList(address));
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return address;
    }

    @Override
    public Passenger create(Passenger entity) {
        super.enterValueForColumn(entity, Passenger::setName, "name", String.class, false, 45);
        super.enterValueForColumn(entity, Passenger::setSurName, "surname", String.class, true, 45);
        super.enterValueForColumn(entity, Passenger::setTelNum, "tel_num", String.class, false, 45);
        super.enterEntityValueForColumn(entity, Passenger::setCreditCard, "credit_card_id", new CreditCardServiceImpl(), false);
        super.enterValueForColumn(entity, Passenger::setRate, "rate", BigDecimal.class, false, -1);
        Passenger createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public Passenger update(Integer id, Passenger entity) {
        String column;
        while (true) {
            System.out.println(ENTER_COLUMN_NAME);
            for (String columnName : COLUMNS_NAMES) {
                System.out.println("\t-" + columnName);
            }
            String inputText = input.nextLine();
            if (COLUMNS_NAMES.contains(inputText)) {
                column = inputText;
                break;
            } else {
                System.out.println(ERROR_INVALID_VALUE);
            }
        }
        switch (column) {
            case "name":
                super.enterValueForColumn(entity, Passenger::setName, "name", String.class, false, 45);
                break;
            case "surname":
                super.enterValueForColumn(entity, Passenger::setSurName, "surname", String.class, true, 45);
                break;
            case "tel_num":
                super.enterValueForColumn(entity, Passenger::setTelNum, "tel_num", String.class, false, 45);
                break;
            case "credit_card_id":
                super.enterEntityValueForColumn(entity, Passenger::setCreditCard, "credit_card_id", new CreditCardServiceImpl(), false);
                break;
            case "rate":
                super.enterValueForColumn(entity, Passenger::setRate, "rate", BigDecimal.class, false, -1);
                break;
            default:
                System.out.println(ERROR_NO_SUCH_OPTION);
        }
        Passenger oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public Passenger delete(Integer id) {
        Passenger address = super.delete(id);
        if (address != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            body.add(entityToList(address));
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return address;
    }

    @Override
    protected List<String> entityToList(Passenger entity) {
        String id = entity.getId().toString();
        String name = entity.getName();
        String surName = entity.getSurName() == null ? "-" : entity.getSurName();
        String telNum = entity.getTelNum();
        String creditCard = entity.getCreditCard().getId().toString();
        String rate = entity.getRate() == null ? "-" : entity.getRate().toString();
        return new LinkedList<>(List.of(id, name, surName, telNum, creditCard, rate));
    }
}

