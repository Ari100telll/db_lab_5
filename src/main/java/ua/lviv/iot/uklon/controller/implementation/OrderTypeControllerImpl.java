package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.entity.OrderType;
import ua.lviv.iot.uklon.model.entity.OrderType;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.OrderTypeServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import java.util.LinkedList;
import java.util.List;

public class OrderTypeControllerImpl extends AbstractController<OrderType> {

    public OrderTypeControllerImpl() {
        super(new OrderTypeServiceImpl());
    }

    private static final List<String> COLUMNS_NAMES = List.of("id", "name");

    @Override
    public List<OrderType> findAll() {
        List<OrderType> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (OrderType address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public OrderType findById(Integer id) {
        OrderType address = super.findById(id);
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
    public OrderType create(OrderType entity) {
        super.enterValueForColumn(entity, OrderType::setName, "name", String.class, false, 45);
        OrderType createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public OrderType update(Integer id, OrderType entity) {
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
        if ("name".equals(column)) {
            super.enterValueForColumn(entity, OrderType::setName, "name", String.class, false, 45);
        } else {
            System.out.println(ERROR_NO_SUCH_OPTION);
        }
        OrderType oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public OrderType delete(Integer id) {
        OrderType address = super.delete(id);
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
    protected List<String> entityToList(OrderType entity) {
        String id = entity.getId().toString();
        String name = entity.getName();
        return new LinkedList<>(List.of(id, name));
    }
}
