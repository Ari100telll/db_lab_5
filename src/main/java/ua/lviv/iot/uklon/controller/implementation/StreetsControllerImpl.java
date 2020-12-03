package ua.lviv.iot.uklon.controller.implementation;

import ua.lviv.iot.uklon.model.entity.Streets;
import ua.lviv.iot.uklon.model.service.implementation.StreetsServiceImpl;
import ua.lviv.iot.uklon.view.Formater;

import java.util.LinkedList;
import java.util.List;

public class StreetsControllerImpl extends AbstractController<Streets> {

    public StreetsControllerImpl() {
        super(new StreetsServiceImpl());
    }

    private static final List<String> COLUMNS_NAMES = List.of("id", "name");

    @Override
    public List<Streets> findAll() {
        List<Streets> entities = super.findAll();
        if (entities != null) {
            List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
            List<List<String>> body = new LinkedList<>();
            for (Streets address : entities) {
                body.add(entityToList(address));
            }
            Formater.formatTable(headerList, body);
        } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
        }
        return entities;
    }

    @Override
    public Streets findById(Integer id) {
        Streets address = super.findById(id);
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
    public Streets create(Streets entity) {
        super.enterValueForColumn(entity, Streets::setName, "name", String.class, false, 45);
        Streets createdEntity = super.create(entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(createdEntity));
        Formater.formatTable(headerList, body);
        return createdEntity;
    }

    @Override
    public Streets update(Integer id, Streets entity) {
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
            super.enterValueForColumn(entity, Streets::setName, "name", String.class, false, 45);
        } else {
            System.out.println(ERROR_NO_SUCH_OPTION);
        }
        Streets oldEntity = super.update(id, entity);
        List<String> headerList = new LinkedList<>(COLUMNS_NAMES);
        List<List<String>> body = new LinkedList<>();
        body.add(entityToList(oldEntity));
        body.add(entityToList(entity));
        Formater.formatTable(headerList, body);
        return entity;
    }

    @Override
    public Streets delete(Integer id) {
        Streets address = super.delete(id);
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
    protected List<String> entityToList(Streets entity) {
        String id = entity.getId().toString();
        String name = entity.getName();
          return new LinkedList<>(List.of(id, name));
    }
}
