package ua.lviv.iot.uklon.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order_type")
public class OrderType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "orderType")
    private List<Order> orders;

    public OrderType() {
    }

    public OrderType(Integer id, String name, List<Order> orders) {
        this.id = id;
        this.name = name;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderType)) return false;
        OrderType orderType = (OrderType) o;
        return id.equals(orderType.id) &&
                name.equals(orderType.name) &&
                Objects.equals(orders, orderType.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, orders);
    }

    @Override
    public String toString() {
        return "OrderType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}