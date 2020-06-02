package com.app.autoreminder.model;

public class Car {

    private Long id;
    private String name;
    private String model;
    private String year;
    private String email;

    public Car(Long id, String name, String model, String year,String email) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Id " + id + " Name " + name + " Model " + model + " Year " + year;
    }


}
