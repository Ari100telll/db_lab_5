package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.controller.Controller;
import ua.lviv.iot.uklon.model.entity.CreditCard;
import ua.lviv.iot.uklon.model.entity.CreditCard;
import ua.lviv.iot.uklon.model.service.implementation.CityServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.CreditCardServiceImpl;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class CreditCardControllerImpl extends AbstractController<CreditCard> {

    private static final List<String> COLUMNS_NAMES = List.of("id", "numer", "date",
            "CV2");


    public CreditCardControllerImpl() {
        super(new CreditCardServiceImpl());
    }

    @Override
    public List<CreditCard> findAll() {
        List<CreditCard> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (CreditCard address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public CreditCard findById(Integer id) {
        CreditCard address = super.findById(id);
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
    public CreditCard create(CreditCard entity) {
        super.enterValueForColumn(entity, CreditCard::setNumer, "numer", String.class, false, 45);
        super.enterValueForColumn(entity, CreditCard::setDate, "date", Date.class, false, -1);
        super.enterValueForColumn(entity, CreditCard::setCv2, "CV2", Integer.class, false, 1);
        CreditCard createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public CreditCard update(Integer id, CreditCard entity) {
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
            case "numer":
                super.enterValueForColumn(entity, CreditCard::setNumer, "numer", String.class, false, 45);
                break;
            case "date":
                super.enterValueForColumn(entity, CreditCard::setDate, "date", Date.class, false, -1);
                break;
            case "CV2":
                super.enterValueForColumn(entity, CreditCard::setCv2, "CV2", Integer.class, true, 1);
                break;

            default:
                System.out.println(ERROR_NO_SUCH_OPTION);
        }
        CreditCard oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public CreditCard delete(Integer id) {
        CreditCard address = super.delete(id);
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
    protected List<String> entityToList(CreditCard entity) {
        String id = entity.getId().toString();
        String numer = entity.getNumer();
        String date = entity.getDate().toString();
        String cv2 = entity.getCv2().toString();
        return new LinkedList<>(List.of(id, numer, date, cv2));
    }
}
