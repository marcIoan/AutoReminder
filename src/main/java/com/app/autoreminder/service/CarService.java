package com.app.autoreminder.service;

import com.app.autoreminder.model.Car;
import com.app.autoreminder.model.CarWithDocument;
import com.app.autoreminder.model.Document;
import com.app.autoreminder.repository.CarRepository;
import com.app.autoreminder.repository.DocumentRepository;

import java.util.ArrayList;

public class CarService {

    private CarRepository carRepository;


    public CarService() {
        carRepository = new CarRepository();

    }

    public void addCar(String name, String model, String year, String email) {
        carRepository.insert(name, model, year, email);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public void modifyCarById(Long id, String name, String model, String year, String email) {
        carRepository.updateById(id, name, model, year, email);
    }

    public ArrayList<Car> selectAll() {
        return carRepository.selectAll();
    }

    public Car selectById(Long id) {
        return carRepository.selectById(id);
    }


    public CarWithDocument selectCarWithDocument(Long carId) {
        Car car = carRepository.selectById(carId);
        DocumentRepository documentRepository = new DocumentRepository();
        ArrayList<Document> documents = documentRepository.selectByCarId(carId);
        return new CarWithDocument(car, documents);
    }


}
