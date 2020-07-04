package com.github.nastyasivko.project_final.model;

import java.util.Date;

public class UserOrder {

    private Long id;
    private String userLogin;
    private String nameRoom;
    private String beds;
    private Date dateStart;
    private Date dateEnd;

    public UserOrder(Long id, String userLogin, String nameRoom, String beds, Date dateStart, Date dateEnd) {
        this.id = id;
        this.userLogin = userLogin;
        this.nameRoom = nameRoom;
        this.beds = beds;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }


    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
