package ua.lviv.iot.uklon.model.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "order_state")
public class OrderState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "orderState")
    private List<Order> orders;

    public OrderState() {
    }

    public OrderState(Integer id, String state, List<Order> orders) {
        this.id = id;
        this.state = state;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        if (!(o instanceof OrderState)) return false;
        OrderState that = (OrderState) o;
        return id.equals(that.id) &&
                state.equals(that.state) &&
                Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, orders);
    }

    @Override
    public String toString() {
        return "OrderState{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", orders=" + orders +
                '}';
    }
}