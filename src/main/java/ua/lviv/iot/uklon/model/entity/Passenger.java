package ua.lviv.iot.uklon.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @Column(name = "tel_num")
    private String telNum;

    @OneToOne
    @JoinColumn(name = "credit_card_id", referencedColumnName = "id", nullable = false)
    private CreditCard creditCard;

    @Column(name = "rate")
    private BigDecimal rate;

    @OneToMany(mappedBy = "passenger")
    private List<Order> orders;

    public Passenger() {
    }

    public Passenger(Integer id, String name, String surName, String telNum, CreditCard creditCard, BigDecimal rate, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.telNum = telNum;
        this.creditCard = creditCard;
        this.rate = rate;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return id.equals(passenger.id) &&
                name.equals(passenger.name) &&
                Objects.equals(surName, passenger.surName) &&
                telNum.equals(passenger.telNum) &&
                creditCard.equals(passenger.creditCard) &&
                Objects.equals(rate, passenger.rate) &&
                Objects.equals(orders, passenger.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, telNum, creditCard, rate, orders);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", telNum='" + telNum + '\'' +
                ", creditCard=" + creditCard +
                ", rate=" + rate +
                ", orders=" + orders +
                '}';
    }
}