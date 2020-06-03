package com.app.autoreminder.model;

import java.util.ArrayList;

public class CarWithDocument {
    private Car car;
    private ArrayList<Document> documents;

    public CarWithDocument(Car car, ArrayList<Document> documents) {
        this.car = car;
        this.documents = documents;
    }


    public Car getCar() {
        return car;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }


    public String toString() {
        return "Car " + car + " Documents " + documents;
    }

}
