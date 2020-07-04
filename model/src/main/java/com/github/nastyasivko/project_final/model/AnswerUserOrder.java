package com.github.nastyasivko.project_final.model;

import java.util.Date;

public class AnswerUserOrder {

    private String userLogin;
    private String nameRoom;
    private String beds;
    private Date dateStart;
    private Date dateEnd;
    private Answer answer;
    private int numberRoom;
    private Integer cost;

    public AnswerUserOrder(String userLogin, String nameRoom, String beds, Date dateStart, Date dateEnd, Answer answer, int numberRoom, Integer cost) {
        this.userLogin = userLogin;
        this.nameRoom = nameRoom;
        this.beds = beds;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.answer = answer;
        this.numberRoom = numberRoom;
        this.cost = cost;
    }

    public AnswerUserOrder(String userLogin, String nameRoom, String beds, Answer answer) {
        this.userLogin = userLogin;
        this.nameRoom = nameRoom;
        this.beds = beds;
        this.answer = answer;
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

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
