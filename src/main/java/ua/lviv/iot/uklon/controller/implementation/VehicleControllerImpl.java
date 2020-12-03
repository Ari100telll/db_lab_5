package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.entity.Vehicle;
import ua.lviv.iot.uklon.model.entity.Vehicle;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.DriverServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.VehicleServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.List;

public class VehicleControllerImpl extends AbstractController<Vehicle> {

    public VehicleControllerImpl() {
        super(new VehicleServiceImpl());
    }

    private static final List<String> COLUMNS_NAMES = List.of("id", "driver_id", "number",
            "model", "places", "trunk_size_in_liter", "color", "insurance_policy");

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (Vehicle address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public Vehicle findById(Integer id) {
        Vehicle address = super.findById(id);
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
    public Vehicle create(Vehicle entity) {
        super.enterEntityValueForColumn(entity, Vehicle::setDriver, "driver_id", new DriverServiceImpl(), false);
        super.enterValueForColumn(entity, Vehicle::setNumber, "number", String.class, false, 45);
        super.enterValueForColumn(entity, Vehicle::setModel, "model", String.class, false, 45);
        super.enterValueForColumn(entity, Vehicle::setPlaces, "places", Integer.class, false, -1);
        super.enterValueForColumn(entity, Vehicle::setTrunkSizeInLiter, "trunk_size_in_liter", Integer.class, true, -1);
        super.enterValueForColumn(entity, Vehicle::setColor, "color", String.class, true, 45);
        super.enterValueForColumn(entity, Vehicle::setInsurancePolicy, "insurance_policy", String.class, false, 45);
        Vehicle createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public Vehicle update(Integer id, Vehicle entity) {
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
            case "driver_id":
                super.enterEntityValueForColumn(entity, Vehicle::setDriver, "driver_id", new DriverServiceImpl(), false);
                break;
            case "number":
                super.enterValueForColumn(entity, Vehicle::setNumber, "number", String.class, false, 45);
                break;
            case "model":
                super.enterValueForColumn(entity, Vehicle::setModel, "model", String.class, false, 45);
                break;
            case "places":
                super.enterValueForColumn(entity, Vehicle::setPlaces, "places", Integer.class, false, -1);
                break;
            case "trunk_size_in_liter":
                super.enterValueForColumn(entity, Vehicle::setTrunkSizeInLiter, "trunk_size_in_liter", Integer.class, true, -1);
                break;
            case "color":
                super.enterValueForColumn(entity, Vehicle::setColor, "color", String.class, true, 45);
                break;
            case "insurance_policy":
                super.enterValueForColumn(entity, Vehicle::setInsurancePolicy, "insurance_policy", String.class, false, 45);
                break;
            default:
                System.out.println(ERROR_NO_SUCH_OPTION);
        }
        Vehicle oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public Vehicle delete(Integer id) {
        Vehicle address = super.delete(id);
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
    protected List<String> entityToList(Vehicle entity) {
        String id = entity.getId().toString();
        String driver = entity.getDriver().getId().toString();
        String number = entity.getNumber();
        String model = entity.getModel();
        String places = entity.getPlaces().toString();
        String trunkSizeInLiter = entity.getTrunkSizeInLiter() == null ? "-" : entity.getTrunkSizeInLiter().toString();
        String color = entity.getColor() == null ? "-" : entity.getColor();
        String insurancePolicy = entity.getInsurancePolicy();
        return new LinkedList<>(List.of(id, driver, number, model, places, trunkSizeInLiter, color, insurancePolicy));
    }
}

