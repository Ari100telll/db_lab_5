package ua.lviv.iot.uklon.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tel_num")
    private String telNum;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @Column(name = "count_of_orders")
    private Integer countOfOrders;

    @Column(name = "drive_license")
    private String driveLicense;

    @Column(name = "rate")
    private BigDecimal rate;

    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicles;

    public Driver() {
    }

    public Driver(Integer id, String telNum, String name, String surName, Integer countOfOrders, String driveLicense, BigDecimal rate, List<Vehicle> vehicles) {
        this.id = id;
        this.telNum = telNum;
        this.name = name;
        this.surName = surName;
        this.countOfOrders = countOfOrders;
        this.driveLicense = driveLicense;
        this.rate = rate;
        this.vehicles = vehicles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense) {
        this.driveLicense = driveLicense;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return id.equals(driver.id) &&
                telNum.equals(driver.telNum) &&
                name.equals(driver.name) &&
                Objects.equals(surName, driver.surName) &&
                countOfOrders.equals(driver.countOfOrders) &&
                driveLicense.equals(driver.driveLicense) &&
                Objects.equals(rate, driver.rate) &&
                Objects.equals(vehicles, driver.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, telNum, name, surName, countOfOrders, driveLicense, rate, vehicles);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", telNum='" + telNum + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", countOfOrders=" + countOfOrders +
                ", driveLicense='" + driveLicense + '\'' +
                ", rate=" + rate +
                ", vehicles=" + vehicles +
                '}';
    }
}