package com.app.autoreminder.api;

import com.app.autoreminder.model.Car;
import com.app.autoreminder.model.CarWithDocument;
import com.app.autoreminder.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarController {

    private CarService carService;

    public CarController() {
        carService = new CarService();
    }



    @GetMapping("/car")
    public ArrayList<Car> getCars() {
        return carService.selectAll();
    }

    @GetMapping("/carDoc/{id}")
    public CarWithDocument getCarsWithDocument(@PathVariable Long id) {
        return carService.selectCarWithDocument(id);
    }

    @GetMapping("/car/{id}")
    public Car getCars(@PathVariable Long id) {
        return carService.selectById(id);
    }


    @PutMapping("/car/{id}")
    public void putCar(@PathVariable Long id, @RequestBody Car c) {
        carService.modifyCarById(id, c.getName(), c.getModel(), c.getYear(), c.getEmail());
    }

    @PostMapping("/car")
    public void postCar(@RequestBody Car c){
        carService.addCar(c.getName(),c.getModel(),c.getYear(),c.getEmail());
    }

     @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id){
         carService.deleteCar(id);
     }





}