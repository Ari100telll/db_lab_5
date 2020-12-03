package ua.lviv.iot.uklon.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "driver_id",
            referencedColumnName = "id", nullable = false)
    private Driver driver;

    @Column(name = "number")
    private String number;

    @Column(name = "model")
    private String model;

    @Column(name = "places")
    private Integer places;

    @Column(name = "trunk_size_in_liter")
    private Integer trunkSizeInLiter;

    @Column(name = "color")
    private String color;

    @Column(name = "insurance_policy")
    private String insurancePolicy;

    @OneToMany(mappedBy = "vehicle")
    private List<Order> orders;

    public Vehicle() {
    }

    public Vehicle(Integer id, Driver driver, String number, String model, Integer places, Integer trunkSizeInLiter, String color, String insurancePolicy, List<Order> orders) {
        this.id = id;
        this.driver = driver;
        this.number = number;
        this.model = model;
        this.places = places;
        this.trunkSizeInLiter = trunkSizeInLiter;
        this.color = color;
        this.insurancePolicy = insurancePolicy;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public Integer getTrunkSizeInLiter() {
        return trunkSizeInLiter;
    }

    public void setTrunkSizeInLiter(Integer trunkSizeInLiter) {
        this.trunkSizeInLiter = trunkSizeInLiter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(String insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return id.equals(vehicle.id) &&
                driver.equals(vehicle.driver) &&
                number.equals(vehicle.number) &&
                model.equals(vehicle.model) &&
                places.equals(vehicle.places) &&
                trunkSizeInLiter.equals(vehicle.trunkSizeInLiter) &&
                Objects.equals(color, vehicle.color) &&
                insurancePolicy.equals(vehicle.insurancePolicy) &&
                Objects.equals(orders, vehicle.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driver, number, model, places, trunkSizeInLiter, color, insurancePolicy, orders);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", driver=" + driver +
                ", number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", places=" + places +
                ", trunkSizeInLiter=" + trunkSizeInLiter +
                ", color='" + color + '\'' +
                ", insurancePolicy='" + insurancePolicy + '\'' +
                ", orders=" + orders +
                '}';
    }
}