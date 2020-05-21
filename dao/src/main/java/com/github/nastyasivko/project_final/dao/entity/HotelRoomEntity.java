package com.github.nastyasivko.project_final.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class HotelRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    @Column
    private String name;
    @Column
    private Integer beds;
    @Column(name = "number_room")
    private Integer numberRoom;

    @ManyToOne
    @JoinColumn(name = "cost_room")
    private CostRoomsEntity costRoomsEntity;

    @ManyToMany(mappedBy = "hotelRoomEntities", cascade = CascadeType.ALL)
    private List<LoginUsersEntity> loginUsersEntities = new ArrayList<>();

    public HotelRoomEntity(Long id, String name, Integer beds, Integer numberRoom, CostRoomsEntity costRoomsEntity) {
        this.id = id;
        this.name = name;
        this.beds = beds;
        this.numberRoom = numberRoom;
    }

    public HotelRoomEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public CostRoomsEntity getCostRoomsEntity() {
        return costRoomsEntity;
    }

    public void setCostRoom(CostRoomsEntity costRoomsEntity) {
        this.costRoomsEntity = costRoomsEntity;
    }
}
