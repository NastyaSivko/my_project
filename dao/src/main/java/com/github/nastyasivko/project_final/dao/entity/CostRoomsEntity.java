package com.github.nastyasivko.project_final.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cost_room")
public class CostRoomsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "costRoomsEntity", cascade = CascadeType.ALL)
    private List<ApprovedOrdersEntity> approvedOrdersEntities = new ArrayList<>(0);

    @Column
    private Integer cost;

    public CostRoomsEntity() {
    }

    public CostRoomsEntity(Long id, Integer cost) {
        this.id = id;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ApprovedOrdersEntity> getApprovedOrdersEntities() {
        return approvedOrdersEntities;
    }

    public void setApprovedOrdersEntities(List<ApprovedOrdersEntity> hotelRooms) {
        this.approvedOrdersEntities = approvedOrdersEntities;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


}
