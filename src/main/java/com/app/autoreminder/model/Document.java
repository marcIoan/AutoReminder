package com.app.autoreminder.model;

public class Document {
    private Long id;
    private Long car_id;
    private String name;
    private String expiration_data;


    public Document(Long id, Long car_id, String name, String expiration_data) {
        this.id = id;
        this.car_id = car_id;
        this.name = name;
        this.expiration_data = expiration_data;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public String getExpiration_data() {
        return expiration_data;
    }


    public String toString() {
        return "ID " + id + " Car_id " + car_id + " Name " + name + "  Expiration Data " + expiration_data;
    }
}
