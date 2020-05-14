package com.github.nastyasivko.project_final.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Data
@ToString
@AllArgsConstructor

@MappedSuperclass
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserOrderEntity userOrderEntity;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long idUserOrder;

    public Orders(Long id, Long idUserLogin) {
        this.id = id;
        this.idUserOrder = idUserLogin;
    }

    public Long getId() {
        return id;
    }

    public Orders() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserOrderEntity getUserOrderEntity() {
        return userOrderEntity;
    }

    public void setUserOrderEntity(UserOrderEntity userOrderEntity) {
        this.userOrderEntity = userOrderEntity;
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
        return id.equals(orders.id) &&
                userOrderEntity.equals(orders.userOrderEntity) &&
                idUserOrder.equals(orders.idUserOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userOrderEntity, idUserOrder);
    }
}
