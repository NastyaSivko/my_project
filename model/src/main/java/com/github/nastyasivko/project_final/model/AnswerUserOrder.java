package com.github.nastyasivko.project_final.model;

public class AnswerUserOrder {

    private String userLogin;
    private String nameRoom;
    private String beds;
    private Answer answer;
    private int numberRoom;
    private Integer cost;

    public AnswerUserOrder(String userLogin, String nameRoom, String beds, Answer answer, int numberRoom, Integer cost) {
        this.userLogin = userLogin;
        this.nameRoom = nameRoom;
        this.beds = beds;
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
