package com.example.todor.blueteam.models;

public class Player {
    public int Age;
    public String Name;
    public String Information;

    public Player(){
        //needed
    }

    public Player(String name, String information) {
        Name = name;
        Information = information;
    }

    @Override
    public String toString() {
        return Name;
    }
}