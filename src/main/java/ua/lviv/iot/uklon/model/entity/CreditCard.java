package ua.lviv.iot.uklon.model.entity;

import java.sql.Date;


import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numer")
    private String numer;

    @Column(name = "date")
    private Date date;

    @Column(name = "CV2")
    private Integer cv2;

    public CreditCard() {
    }

    public CreditCard(Integer id, String numer, Date date, Integer cv2) {
        super();
        this.id = id;
        this.numer = numer;
        this.date = date;
        this.cv2 = cv2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCv2() {
        return cv2;
    }

    public void setCv2(Integer cv2) {
        this.cv2 = cv2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cv2 == null) ? 0 : cv2.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((numer == null) ? 0 : numer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreditCard other = (CreditCard) obj;
        if (cv2 == null) {
            if (other.cv2 != null)
                return false;
        } else if (!cv2.equals(other.cv2))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (numer == null) {
            if (other.numer != null)
                return false;
        } else if (!numer.equals(other.numer))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CreditCard [id=" + id + ", numer=" + numer + ", date=" + date + ", cv2=" + cv2 + "]";
    }

}
