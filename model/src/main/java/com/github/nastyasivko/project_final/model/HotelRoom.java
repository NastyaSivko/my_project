package com.github.nastyasivko.project_final.model;

public class HotelRoom {

    private String name;
    private int beds;
    private int numberRoom;

    public HotelRoom(String name, int beds, Integer numberRoom) {
        this.name = name;
        this.beds = beds;
        this.numberRoom = numberRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }
}
