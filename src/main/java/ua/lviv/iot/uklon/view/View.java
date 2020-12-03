package ua.lviv.iot.uklon.view;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import ua.lviv.iot.uklon.controller.implementation.AdressControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.CityControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.CreditCardControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.DriverControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.OrderControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.OrderStateControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.OrderTypeControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.PassengerControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.StreetsControllerImpl;
import ua.lviv.iot.uklon.controller.implementation.VehicleControllerImpl;
import ua.lviv.iot.uklon.model.entity.Adress;
import ua.lviv.iot.uklon.model.entity.City;
import ua.lviv.iot.uklon.model.entity.CreditCard;
import ua.lviv.iot.uklon.model.entity.Driver;
import ua.lviv.iot.uklon.model.entity.Order;
import ua.lviv.iot.uklon.model.entity.OrderState;
import ua.lviv.iot.uklon.model.entity.OrderType;
import ua.lviv.iot.uklon.model.entity.Passenger;
import ua.lviv.iot.uklon.model.entity.Streets;
import ua.lviv.iot.uklon.model.entity.Vehicle;

public class View {
    private static final String KEY_EXIT = "Q";

    private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

    private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
    private static final String TEXT_GO_BACK = "Go back or quit";

    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    public View() {
    }

    public void show() {
        showTablesMenu();
    }

    private void showTablesMenu() {
        Map<String, String> tablesMenu = generateTablesMenu();
        Map<String, Printable> tablesMenuMethods = generateTablesMenuMethods();
        showMenuFromMaps(tablesMenu, tablesMenuMethods);
    }

    private Map<String, String> generateTablesMenu() {
        Map<String, String> tablesMenu = new LinkedHashMap<>();
        tablesMenu.put("1", "Table: Adress");
        tablesMenu.put("2", "Table: City");
        tablesMenu.put("3", "Table: CreditCard");
        tablesMenu.put("4", "Table: Driver");
        tablesMenu.put("5", "Table: Order");
        tablesMenu.put("6", "Table: OrderState");
        tablesMenu.put("7", "Table: OrderType");
        tablesMenu.put("8", "Table: Passenger");
        tablesMenu.put("9", "Table: Streets");
        tablesMenu.put("10", "Table: Vehicle");
        return tablesMenu;
    }

    private Map<String, Printable> generateTablesMenuMethods() {
        Map<String, Printable> tableMenuMethods = new LinkedHashMap<>();
        tableMenuMethods.put("1", this::showAdressMenu);
        tableMenuMethods.put("2", this::showCityMenu);
        tableMenuMethods.put("3", this::showCreditCardMenu);
        tableMenuMethods.put("4", this::showDriverMenu);
        tableMenuMethods.put("5", this::showOrderMenu);
        tableMenuMethods.put("6", this::showOrderStateMenu);
        tableMenuMethods.put("7", this::showOrderTypeMenu);
        tableMenuMethods.put("8", this::showPassengerMenu);
        tableMenuMethods.put("9", this::showStreetsMenu);
        tableMenuMethods.put("10", this::showVehicleMenu);
        return tableMenuMethods;
    }

    private void showAdressMenu() {
        Map<String, String> menu = generateAdressMenu();
        Map<String, Printable> menuMethods = generateAdressMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showCityMenu() {
        Map<String, String> menu = generateCityMenu();
        Map<String, Printable> menuMethods = generateCityMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showCreditCardMenu() {
        Map<String, String> menu = generateCreditCardMenu();
        Map<String, Printable> menuMethods = generateCreditCardMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showDriverMenu() {
        Map<String, String> menu = generateDriverMenu();
        Map<String, Printable> menuMethods = generateDriverMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showOrderMenu() {
        Map<String, String> menu = generateOrderMenu();
        Map<String, Printable> menuMethods = generateOrderMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showOrderStateMenu() {
        Map<String, String> menu = generateOrderStateMenu();
        Map<String, Printable> menuMethods = generateOrderStateMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showOrderTypeMenu() {
        Map<String, String> menu = generateOrderTypeMenu();
        Map<String, Printable> menuMethods = generateOrderTypeMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showPassengerMenu() {
        Map<String, String> menu = generatePassengerMenu();
        Map<String, Printable> menuMethods = generatePassengerMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showStreetsMenu() {
        Map<String, String> menu = generateStreetsMenu();
        Map<String, Printable> menuMethods = generateStreetsMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showVehicleMenu() {
        Map<String, String> menu = generateVehicleMenu();
        Map<String, Printable> menuMethods = generateVehicleMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private Map<String, String> generateAdressMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("1", "Select all from Adress");
        menu.put("2", "Select Adress");
        menu.put("3", "Create Adress");
        menu.put("4", "Update Adress");
        menu.put("5", "Delete Adress");
        return menu;
    }

    private Map<String, Printable> generateAdressMenuMethods() {
        AdressControllerImpl controller = new AdressControllerImpl();
        ViewManager<Adress> operation = new ViewManager<>(controller, Adress.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateCityMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("1", "Select all from City");
        menu.put("2", "Select City");
        menu.put("3", "Create City");
        menu.put("4", "Update City");
        menu.put("5", "Delete City");
        return menu;
    }

    private Map<String, Printable> generateCityMenuMethods() {
        CityControllerImpl controller = new CityControllerImpl();
        ViewManager<City> operation = new ViewManager<>(controller, City.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateCreditCardMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from CreditCard");
        menu.put("2", "Select CreditCard");
        menu.put("3", "Create CreditCard");
        menu.put("4", "Update CreditCard");
        menu.put("5", "Delete CreditCard");
        return menu;
    }

    private Map<String, Printable> generateCreditCardMenuMethods() {
        CreditCardControllerImpl controller = new CreditCardControllerImpl();
        ViewManager<CreditCard> operation = new ViewManager<>(controller, CreditCard.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateDriverMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from Driver");
        menu.put("2", "Select Driver");
        menu.put("3", "Create Driver");
        menu.put("4", "Update Driver");
        menu.put("5", "Delete Driver");
        return menu;
    }

    private Map<String, Printable> generateDriverMenuMethods() {
        DriverControllerImpl controller = new DriverControllerImpl();
        ViewManager<Driver> operation = new ViewManager<>(controller, Driver.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateOrderMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from Order");
        menu.put("2", "Select Order");
        menu.put("3", "Create Order");
        menu.put("4", "Update Order");
        menu.put("5", "Delete Order");
        return menu;
    }

    private Map<String, Printable> generateOrderMenuMethods() {
        OrderControllerImpl controller = new OrderControllerImpl();
        ViewManager<Order> operation = new ViewManager<>(controller, Order.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateOrderStateMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from OrderState");
        menu.put("2", "Select OrderState");
        menu.put("3", "Create OrderState");
        menu.put("4", "Update OrderState");
        menu.put("5", "Delete OrderState");
        return menu;
    }

    private Map<String, Printable> generateOrderStateMenuMethods() {
        OrderStateControllerImpl controller = new OrderStateControllerImpl();
        ViewManager<OrderState> operation = new ViewManager<>(controller, OrderState.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateOrderTypeMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from OrderType");
        menu.put("2", "Select OrderType");
        menu.put("3", "Create OrderType");
        menu.put("4", "Update OrderType");
        menu.put("5", "Delete OrderType");
        return menu;
    }

    private Map<String, Printable> generateOrderTypeMenuMethods() {
        OrderTypeControllerImpl controller = new OrderTypeControllerImpl();
        ViewManager<OrderType> operation = new ViewManager<>(controller, OrderType.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generatePassengerMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from Passenger");
        menu.put("2", "Select Passenger");
        menu.put("3", "Create Passenger");
        menu.put("4", "Update Passenger");
        menu.put("5", "Delete Passenger");
        return menu;
    }

    private Map<String, Printable> generatePassengerMenuMethods() {
        PassengerControllerImpl controller = new PassengerControllerImpl();
        ViewManager<Passenger> operation = new ViewManager<>(controller, Passenger.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateStreetsMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from Streets");
        menu.put("2", "Select Streets");
        menu.put("3", "Create Streets");
        menu.put("4", "Update Streets");
        menu.put("5", "Delete Streets");
        return menu;
    }

    private Map<String, Printable> generateStreetsMenuMethods() {
        StreetsControllerImpl controller = new StreetsControllerImpl();
        ViewManager<Streets> operation = new ViewManager<>(controller, Streets.class);
        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private Map<String, String> generateVehicleMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all from ");
        menu.put("2", "Select ");
        menu.put("3", "Create ");
        menu.put("4", "Update ");
        menu.put("5", "Delete ");
        return menu;
    }

    private Map<String, Printable> generateVehicleMenuMethods() {
        VehicleControllerImpl controller = new VehicleControllerImpl();
        ViewManager<Vehicle> operation = new ViewManager<>(controller, Vehicle.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
        menuMethods.put("1", operation::findAll);
        menuMethods.put("2", operation::findById);
        menuMethods.put("3", operation::create);
        menuMethods.put("4", operation::update);
        menuMethods.put("5", operation::delete);
        return menuMethods;
    }

    private void showMenuFromMaps(Map<String, String> keyName, Map<String, Printable> keyMethod) {
        String keyMenu;
        do {
            printMenu(keyName);
            System.out.println(TEXT_SELECT_MENU_OPTION);
            keyMenu = input.nextLine().toUpperCase();
            Printable method = keyMethod.get(keyMenu);
            if (method != null) {
                method.print();
            } else if (!keyMenu.equals(KEY_EXIT)) {
                System.out.println(ERROR_NO_SUCH_OPTION);
            }
        } while (!keyMenu.equals(KEY_EXIT));
    }

    private void printMenu(Map<String, String> keyName) {
        for (String key : keyName.keySet()) {
            System.out.format("%3s - %s%n", key, keyName.get(key));
        }
        System.out.format("%3s - %s%n", KEY_EXIT, TEXT_GO_BACK);
    }

}
