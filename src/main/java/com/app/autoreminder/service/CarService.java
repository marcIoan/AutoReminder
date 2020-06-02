package com.app.autoreminder.service;

import com.app.autoreminder.model.Car;
import com.app.autoreminder.model.Document;
import com.app.autoreminder.repository.CarRepository;

import java.util.ArrayList;

public class CarService {

    private CarRepository carRepository;
    // get car with documents
    // call car repository for car
    // call carRepository for document


    public CarService(){
        carRepository = new CarRepository();
    }

    public void addCar(String name,String model,String year,String email) {
        carRepository.insert(name,model,year,email);
    }

    public ArrayList<Car> SelectAll(){
        return carRepository.selectAll();
    }




}
