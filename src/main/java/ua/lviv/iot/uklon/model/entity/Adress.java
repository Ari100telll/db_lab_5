package ua.lviv.iot.uklon.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "streets_id", referencedColumnName = "id", nullable = false)
    private Streets streets;

    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(name = "house_letter")
    private String houseLetter;

    @ManyToOne
    @JoinColumn(name = "city_id",
            referencedColumnName = "id", nullable = false)
    private City cityId;

    @OneToMany(mappedBy = "adressStart")
    private List<Order> ordersStart;

    @OneToMany(mappedBy = "adressEnd")
    private List<Order> ordersEnd;

    public Adress() {
    }

    public Adress(Integer id, Streets streets, Integer houseNumber, String houseLetter, City cityId, List<Order> ordersStart, List<Order> ordersEnd) {
        this.id = id;
        this.streets = streets;
        this.houseNumber = houseNumber;
        this.houseLetter = houseLetter;
        this.cityId = cityId;
        this.ordersStart = ordersStart;
        this.ordersEnd = ordersEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Streets getStreets() {
        return streets;
    }

    public void setStreets(Streets streets) {
        this.streets = streets;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseLetter() {
        return houseLetter;
    }

    public void setHouseLetter(String houseLetter) {
        this.houseLetter = houseLetter;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public List<Order> getOrdersStart() {
        return ordersStart;
    }

    public void setOrdersStart(List<Order> ordersStart) {
        this.ordersStart = ordersStart;
    }

    public List<Order> getOrdersEnd() {
        return ordersEnd;
    }

    public void setOrdersEnd(List<Order> ordersEnd) {
        this.ordersEnd = ordersEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return id.equals(adress.id) &&
                streets.equals(adress.streets) &&
                houseNumber.equals(adress.houseNumber) &&
                Objects.equals(houseLetter, adress.houseLetter) &&
                cityId.equals(adress.cityId) &&
                Objects.equals(ordersStart, adress.ordersStart) &&
                Objects.equals(ordersEnd, adress.ordersEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streets, houseNumber, houseLetter, cityId, ordersStart, ordersEnd);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", streets=" + streets +
                ", houseNumber=" + houseNumber +
                ", houseLetter='" + houseLetter + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}