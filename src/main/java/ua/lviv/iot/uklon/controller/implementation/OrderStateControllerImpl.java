package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.entity.OrderState;
import ua.lviv.iot.uklon.model.entity.OrderState;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.OrderStateServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import java.util.LinkedList;
import java.util.List;

public class OrderStateControllerImpl extends AbstractController<OrderState> {

    public OrderStateControllerImpl() {
        super(new OrderStateServiceImpl());
    }

    private static final List<String> COLUMNS_NAMES = List.of("id", "state");

    @Override
    public List<OrderState> findAll() {
        List<OrderState> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (OrderState address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public OrderState findById(Integer id) {
        OrderState address = super.findById(id);
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
    public OrderState create(OrderState entity) {
        super.enterValueForColumn(entity, OrderState::setState, "state", String.class, false, 45);
        OrderState createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public OrderState update(Integer id, OrderState entity) {
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
        if ("state".equals(column)) {
            super.enterValueForColumn(entity, OrderState::setState, "state", String.class, false, 45);
        } else {
            System.out.println(ERROR_NO_SUCH_OPTION);
        }
        OrderState oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public OrderState delete(Integer id) {
        OrderState address = super.delete(id);
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
    protected List<String> entityToList(OrderState entity) {
        String id = entity.getId().toString();
        String state = entity.getState();
        return new LinkedList<>(List.of(id, state));
    }
}

