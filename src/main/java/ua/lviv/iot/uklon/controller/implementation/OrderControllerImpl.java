package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.entity.Order;
import ua.lviv.iot.uklon.model.entity.Order;
import ua.lviv.iot.uklon.model.entity.Passenger;
import ua.lviv.iot.uklon.model.service.implementation.*;
import ua.lviv.iot.uklon.view.Formater;

import java.util.LinkedList;
import java.util.List;

public class OrderControllerImpl extends AbstractController<Order> {

    public OrderControllerImpl() {
        super(new OrderServiceImpl());
    }

    private static final List<String> COLUMNS_NAMES = List.of("id", "passenger_id", "cost",
            "estimated_departure_time", "estimated_arrival_time", "count_passangers", "paymant_type", "order_type_id", "adress_start_id", "adress_end_id", "vehicle_id", "order_state_id");

    @Override
    public List<Order> findAll() {
        List<Order> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (Order address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public Order findById(Integer id) {
        Order address = super.findById(id);
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
    public Order create(Order entity) {
        super.enterEntityValueForColumn(entity, Order::setPassenger, "passenger_id", new PassengerServiceImpl(), false);
        super.enterValueForColumn(entity, Order::setCost, "cost", Integer.class, false, -1);
        super.enterValueForColumn(entity, Order::setEstimatedDepartureTime, "estimated_departure_time", String.class, true, 45);
        super.enterValueForColumn(entity, Order::setEstimatedArrivalTime, "estimated_arrival_time", String.class, true, 45);
        super.enterValueForColumn(entity, Order::setCountPassangers, "count_passangers", Integer.class, true, -1);
        super.enterValueForColumn(entity, Order::setPaymantType, "paymant_type", String.class, false, 45);
        super.enterEntityValueForColumn(entity, Order::setOrderType, "order_type_id", new OrderTypeServiceImpl(), false);
        super.enterEntityValueForColumn(entity, Order::setAdressStart, "adress_start_id", new AdressServiceImpl(), false);
        super.enterEntityValueForColumn(entity, Order::setAdressEnd, "adress_end_id", new AdressServiceImpl(), false);
        super.enterEntityValueForColumn(entity, Order::setVehicle, "vehicle_id", new VehicleServiceImpl(), false);
        super.enterEntityValueForColumn(entity, Order::setOrderState, "order_state_id", new OrderStateServiceImpl(), false);
        Order createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public Order update(Integer id, Order entity) {
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
            case "passenger_id":
                super.enterEntityValueForColumn(entity, Order::setPassenger, "passenger_id", new PassengerServiceImpl(), false);
                break;
            case "cost":
                super.enterValueForColumn(entity, Order::setCost, "cost", Integer.class, false, -1);
                break;
            case "estimated_departure_time":
                super.enterValueForColumn(entity, Order::setEstimatedDepartureTime, "estimated_departure_time", String.class, true, 45);
                break;
            case "estimated_arrival_time":
                super.enterValueForColumn(entity, Order::setEstimatedArrivalTime, "estimated_arrival_time", String.class, true, 45);
                break;
            case "count_passangers":
                super.enterValueForColumn(entity, Order::setCountPassangers, "count_passangers", Integer.class, true, -1);
                break;
            case "paymant_type":
                super.enterValueForColumn(entity, Order::setPaymantType, "paymant_type", String.class, false, 45);
                break;
            case "order_type_id":
                super.enterEntityValueForColumn(entity, Order::setOrderType, "order_type_id", new OrderTypeServiceImpl(), false);
                break;
            case "adress_start_id":
                super.enterEntityValueForColumn(entity, Order::setAdressStart, "adress_start_id", new AdressServiceImpl(), false);
                break;
            case "adress_end_id":
                super.enterEntityValueForColumn(entity, Order::setAdressEnd, "adress_end_id", new AdressServiceImpl(), false);
                break;
            case "vehicle_id":
                super.enterEntityValueForColumn(entity, Order::setVehicle, "vehicle_id", new VehicleServiceImpl(), false);
                break;
            case "order_state_id":
                super.enterEntityValueForColumn(entity, Order::setOrderState, "order_state_id", new OrderStateServiceImpl(), false);
                break;
            default:
                System.out.println(ERROR_NO_SUCH_OPTION);
        }
        Order oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public Order delete(Integer id) {
        Order address = super.delete(id);
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
    protected List<String> entityToList(Order entity) {
        String id = entity.getId().toString();
        String passenger = entity.getPassenger().getId().toString();
        String cost = entity.getCost().toString();
        String estimatedDepartureTime = entity.getEstimatedDepartureTime() == null ? "-" : entity.getEstimatedDepartureTime();
        String estimatedArrivalTime = entity.getEstimatedArrivalTime() == null ? "-" : entity.getEstimatedArrivalTime();
        String countPassangers = entity.getCountPassangers() == null ? "-" : entity.getCountPassangers().toString();
        String paymantType = entity.getPaymantType();
        String orderType = entity.getOrderType().getName();
        String adressStart = entity.getAdressStart().getId().toString();
        String adressEnd = entity.getAdressEnd().getId().toString();
        String vehicle = entity.getVehicle().getId().toString();
        String orderState = entity.getOrderState().getState();
        return new LinkedList<>(List.of(id, passenger, cost, estimatedDepartureTime, estimatedArrivalTime, countPassangers, paymantType, orderType, adressStart, adressEnd, vehicle, orderState));
    }
}

