package ua.lviv.iot.uklon.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "passenger_id",
            referencedColumnName = "id", nullable = false)
    private Passenger passenger;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "estimated_departure_time")
    private String estimatedDepartureTime;

    @Column(name = "estimated_arrival_time")
    private String estimatedArrivalTime;

    @Column(name = "count_passangers")
    private Integer countPassangers;

    @Column(name = "paymant_type")
    private String paymantType;

    @ManyToOne
    @JoinColumn(name = "order_type_id",
            referencedColumnName = "id", nullable = false)
    private OrderType orderType;

    @ManyToOne
    @JoinColumn(name = "adress_start_id",
            referencedColumnName = "id", nullable = false)
    private Adress adressStart;

    @ManyToOne
    @JoinColumn(name = "adress_end_id",
            referencedColumnName = "id", nullable = false)
    private Adress adressEnd;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",
            referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "order_state_id",
            referencedColumnName = "id", nullable = false)
    private OrderState orderState;

    public Order() {
    }

    public Order(Integer id, Passenger passenger, Integer cost, String estimatedDepartureTime, String estimatedArrivalTime, Integer countPassangers, String paymantType, OrderType orderType, Adress adressStart, Adress adressEnd, Vehicle vehicle, OrderState orderState) {
        this.id = id;
        this.passenger = passenger;
        this.cost = cost;
        this.estimatedDepartureTime = estimatedDepartureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.countPassangers = countPassangers;
        this.paymantType = paymantType;
        this.orderType = orderType;
        this.adressStart = adressStart;
        this.adressEnd = adressEnd;
        this.vehicle = vehicle;
        this.orderState = orderState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(String estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public Integer getCountPassangers() {
        return countPassangers;
    }

    public void setCountPassangers(Integer countPassangers) {
        this.countPassangers = countPassangers;
    }

    public String getPaymantType() {
        return paymantType;
    }

    public void setPaymantType(String paymantType) {
        this.paymantType = paymantType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Adress getAdressStart() {
        return adressStart;
    }

    public void setAdressStart(Adress adressStart) {
        this.adressStart = adressStart;
    }

    public Adress getAdressEnd() {
        return adressEnd;
    }

    public void setAdressEnd(Adress adressEnd) {
        this.adressEnd = adressEnd;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                passenger.equals(order.passenger) &&
                cost.equals(order.cost) &&
                Objects.equals(estimatedDepartureTime, order.estimatedDepartureTime) &&
                Objects.equals(estimatedArrivalTime, order.estimatedArrivalTime) &&
                Objects.equals(countPassangers, order.countPassangers) &&
                paymantType.equals(order.paymantType) &&
                orderType.equals(order.orderType) &&
                adressStart.equals(order.adressStart) &&
                adressEnd.equals(order.adressEnd) &&
                vehicle.equals(order.vehicle) &&
                orderState.equals(order.orderState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passenger, cost, estimatedDepartureTime, estimatedArrivalTime, countPassangers, paymantType, orderType, adressStart, adressEnd, vehicle, orderState);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", cost=" + cost +
                ", estimatedDepartureTime='" + estimatedDepartureTime + '\'' +
                ", estimatedArrivalTime='" + estimatedArrivalTime + '\'' +
                ", countPassangers=" + countPassangers +
                ", paymantType='" + paymantType + '\'' +
                ", orderType=" + orderType +
                ", adressStart=" + adressStart +
                ", adressEnd=" + adressEnd +
                ", vehicle=" + vehicle +
                ", orderState=" + orderState +
                '}';
    }
}