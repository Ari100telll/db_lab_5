package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.model.entity.Adress;
import ua.lviv.iot.uklon.model.service.implementation.AdressServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import java.util.LinkedList;
import java.util.List;

public class AdressControllerImpl extends AbstractController<Adress> {


    public AdressControllerImpl() {
        super(new AdressServiceImpl());
    }

    private static final List<String> COLUMNS_NAMES = List.of("id", "streets_id", "house_number",
            "house_letter", "city_id");

    @Override
    public List<Adress> findAll() {
        List<Adress> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (Adress address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public Adress findById(Integer id) {
        Adress address = super.findById(id);
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
    public Adress create(Adress entity) {
        super.enterEntityValueForColumn(entity, Adress::setStreets, "streets_id", new StreetsServiceImpl(), false);
        super.enterValueForColumn(entity, Adress::setHouseNumber, "house_number", Integer.class, false, -1);
        super.enterValueForColumn(entity, Adress::setHouseLetter, "house_letter", String.class, true, 1);
        super.enterEntityValueForColumn(entity, Adress::setCityId, "city_id", new CityServiceImpl(), false);
        Adress createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public Adress update(Integer id, Adress entity) {
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
            case "streets_id":
                super.enterEntityValueForColumn(entity, Adress::setStreets, "streets_id", new StreetsServiceImpl(), false);
                break;
            case "house_number":
                super.enterValueForColumn(entity, Adress::setHouseNumber, "house_number", Integer.class, false, -1);
                break;
            case "house_letter":
                super.enterValueForColumn(entity, Adress::setHouseLetter, "house_letter", String.class, true, 1);
                break;
            case "city_id":
                super.enterEntityValueForColumn(entity, Adress::setCityId, "city_id", new CityServiceImpl(), false);
                break;
            default:
                System.out.println(ERROR_NO_SUCH_OPTION);
        }
        Adress oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public Adress delete(Integer id) {
        Adress address = super.delete(id);
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
    protected List<String> entityToList(Adress entity) {
        String id = entity.getId().toString();
        String streetName = entity.getStreets().getName();
        String house_number = entity.getHouseNumber().toString();
        String house_letter = entity.getHouseLetter() == null ? "-" : entity.getHouseLetter();
        String cityName = entity.getCityId().getName();
        return new LinkedList<>(List.of(id, streetName, house_number, house_letter, cityName));
    }
}
