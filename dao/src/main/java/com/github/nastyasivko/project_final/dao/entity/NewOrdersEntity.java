package com.github.nastyasivko.project_final.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "new_orders")
public class NewOrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "user_login")
    private String userlogin;
    @Column(name = "name_room")
    private String nameRoom;
    @Column(name = "number_of_beds")
    private String numberOfBeds;

    public NewOrdersEntity(Long id, String userlogin, String nameRoom, String numberOfBeds){
        this.id = id;
        this.userlogin = userlogin;
        this.nameRoom = nameRoom;
        this.numberOfBeds = numberOfBeds;
    }

    public NewOrdersEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(String numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

}
