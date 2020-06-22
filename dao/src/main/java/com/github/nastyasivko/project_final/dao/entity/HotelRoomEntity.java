package com.github.nastyasivko.project_final.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class HotelRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    @Column
    private String name;
    @Column
    private String beds;
    @Column(name = "number_room")
    private String numberRoom;

    @ManyToMany(mappedBy = "hotelRoomEntities", cascade = CascadeType.ALL)
    private List<LoginUsersEntity> loginUsersEntities = new ArrayList<>();

    public HotelRoomEntity(Long id, String name, String beds, String numberRoom) {
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

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(String numberRoom) {
        this.numberRoom = numberRoom;
    }

    }
