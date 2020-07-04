package com.github.nastyasivko.project_final.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "new_order")
public class NewOrderEntity {

    private Long id;

    private String userlogin;

    private String nameRoom;

    private String numberOfBeds;

    private Date dateStart;

    private Date dateEnd;

    public NewOrderEntity(Long id, String userlogin, String nameRoom, String numberOfBeds, Date dateStart, Date dateEnd) {
        this.id = id;
        this.userlogin = userlogin;
        this.nameRoom = nameRoom;
        this.numberOfBeds = numberOfBeds;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public NewOrderEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_login")
    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    @Column(name = "name_room")
    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    @Column(name = "number_of_beds")
    public String getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(String numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
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
}
