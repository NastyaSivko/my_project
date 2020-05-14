package com.github.nastyasivko.project_final.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cost_rooms")
public class CostRoomsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "costRoomsEntity", cascade = CascadeType.ALL)
    private List<HotelRoomEntity> hotelRooms = new ArrayList<>(0);

    @Column
    private Integer cost;

    public CostRoomsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HotelRoomEntity> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(List<HotelRoomEntity> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


}
