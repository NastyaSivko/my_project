package com.github.nastyasivko.project_final.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Data
@ToString

@MappedSuperclass
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long idUserOrder;

    public Orders(Long id, Long idUserOrder) {
        this.id = id;
        this.idUserOrder = idUserOrder;
    }

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserOrder() {
        return idUserOrder;
    }

    public void setIdUserOrder(Long idUserOrder) {
        this.idUserOrder = idUserOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return Objects.equals(getId(), orders.getId()) &&
                Objects.equals(getIdUserOrder(), orders.getIdUserOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdUserOrder());
    }
}
