package com.github.nastyasivko.project_final.model;

public class UserOrder {

    private Long id;
    private String userLogin;
    private String nameRoom;
    private String beds;

    public UserOrder(Long id, String userLogin, String nameRoom, String beds) {
        this.id = id;
        this.userLogin = userLogin;
        this.nameRoom = nameRoom;
        this.beds = beds;
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

}
