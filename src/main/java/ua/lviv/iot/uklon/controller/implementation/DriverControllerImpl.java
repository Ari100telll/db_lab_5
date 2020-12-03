package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.entity.Driver;
import ua.lviv.iot.uklon.model.entity.Driver;
import ua.lviv.iot.uklon.model.service.implementation.DriverServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.DriverServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class DriverControllerImpl extends AbstractController<Driver> {

    private static final List<String> COLUMNS_NAMES = List.of("id", "tel_num", "name",
            "surname", "count_of_orders", "drive_license", "rate");

    public DriverControllerImpl() {
        super(new DriverServiceImpl());
    }


    @Override
    public List<Driver> findAll() {
        List<Driver> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (Driver address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public Driver findById(Integer id) {
        Driver address = super.findById(id);
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
    public Driver create(Driver entity) {
        super.enterValueForColumn(entity, Driver::setTelNum, "tel_num", String.class, false, 45);
        super.enterValueForColumn(entity, Driver::setName, "name", String.class, false, 45);
        super.enterValueForColumn(entity, Driver::setSurName, "surname", String.class, true, 45);
        super.enterValueForColumn(entity, Driver::setCountOfOrders, "count_of_orders", Integer.class, false, -1);
        super.enterValueForColumn(entity, Driver::setDriveLicense, "drive_license", String.class, false, 45);
        super.enterValueForColumn(entity, Driver::setRate, "rate", BigDecimal.class, true, -1);
        Driver createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public Driver update(Integer id, Driver entity) {
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
            case "tel_num":
                super.enterValueForColumn(entity, Driver::setTelNum, "tel_num", String.class, false, 45);
                break;
            case "name":
                super.enterValueForColumn(entity, Driver::setName, "name", String.class, false, 45);
                break;
            case "surname":
                super.enterValueForColumn(entity, Driver::setSurName, "surname", String.class, true, 45);
                break;
            case "count_of_orders":
                super.enterValueForColumn(entity, Driver::setCountOfOrders, "count_of_orders", Integer.class, false, -1);
                break;
            case "drive_license":
                super.enterValueForColumn(entity, Driver::setDriveLicense, "drive_license", String.class, false, 45);
                break;
            case "rate":
                super.enterValueForColumn(entity, Driver::setRate, "rate", BigDecimal.class, true, -1);
                break;

            default:
                System.out.println(ERROR_NO_SUCH_OPTION);
        }
        Driver oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public Driver delete(Integer id) {
        Driver address = super.delete(id);
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
    protected List<String> entityToList(Driver entity) {
        String id = entity.getId().toString();
        String telNum = entity.getTelNum();
        String name = entity.getName();
        String surName = entity.getSurName() == null ? "-" : entity.getSurName();
        String countOfOrders = entity.getCountOfOrders().toString();
        String driveLicense = entity.getDriveLicense();
        String rate = entity.getRate().toString() == null ? "-" : entity.getRate().toString();;
        return new LinkedList<>(List.of(id, telNum, name, surName, countOfOrders, driveLicense, rate));
    }
}

