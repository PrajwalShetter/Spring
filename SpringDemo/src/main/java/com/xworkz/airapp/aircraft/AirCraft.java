package com.xworkz.airapp.aircraft;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AirCraft  {

    private int id;
    private String name;
    private int model;

    public  AirCraft(){
        System.out.println("class object created");
    }
    public void war(){
        System.out.println("hello hello");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "AirCraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model=" + model +
                '}';
    }

    @PostConstruct
    public void initAirCraft(){
        System.out.println("Bean initialize");
    }
    @PreDestroy
    public void destroyController(){
        System.out.println("Closing all the costly resources");
    }
}
