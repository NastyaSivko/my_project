package com.github.nastyasivko.project_final.dao.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@ToString
@MappedSuperclass
public class Order {

    private Long id;

    private Long idUserOrder;

    private Date dateStart;

    private Date dateEnd;

    public Order(Long id, Long idUserOrder, Date dateStart, Date dateEnd) {
        this.id = id;
        this.idUserOrder = idUserOrder;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_id")
    public Long getIdUserOrder() {
        return idUserOrder;
    }

    public void setIdUserOrder(Long idUserOrder) {
        this.idUserOrder = idUserOrder;
    }

    @Column(name = "date_start")
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Column(name = "date_end")
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId()) &&
                Objects.equals(getIdUserOrder(), order.getIdUserOrder()) &&
                Objects.equals(getDateStart(), order.getDateStart()) &&
                Objects.equals(getDateEnd(), order.getDateEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdUserOrder(), getDateStart(), getDateEnd());
    }
}
