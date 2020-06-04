package com.app.autoreminder.api;

import com.app.autoreminder.model.Car;
import com.app.autoreminder.model.CarWithDocument;
import com.app.autoreminder.model.Document;
import com.app.autoreminder.repository.DocumentRepository;
import com.app.autoreminder.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AutoReminderController {

    private CarService carService;
    private DocumentRepository documentRepository;

    public AutoReminderController() {
        carService = new CarService();
        documentRepository = new DocumentRepository();
    }


    @GetMapping("/car")
    public ArrayList<Car> getCars() {
        return carService.selectAll();
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
    public void postCar(@RequestBody Car c) {
        carService.addCar(c.getName(), c.getModel(), c.getYear(), c.getEmail());
    }


    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }


    @GetMapping("/car/{id}/doc")
    public CarWithDocument getCarsWithDocument(@PathVariable Long id) {
        return carService.selectCarWithDocument(id);
    }

    @GetMapping("/car/{carId}/doc/{docId}")
    public Document getSpecificDocumentByIdAssociateACar(@PathVariable Long carId, @PathVariable long docId) {
        return documentRepository.selectById(docId);
    }

    @PostMapping("/car/{carId}/doc")
    public void postSpecificDocumentForSpecificCar(@PathVariable Long carId, @RequestBody Document d) {
        documentRepository.insert(carId, d.getName(), d.getExpiration_data());
    }

    @PutMapping("/car/{carId}/doc/{docId}")
    public void putDocumentAssociatedWithCar(@PathVariable Long carId, @PathVariable Long docId, @RequestBody Document d) {
        documentRepository.updateById(docId, carId, d.getName(), d.getExpiration_data());
    }



    @DeleteMapping("/car/{carId}/doc/{docId}")
    public void deleteDocumentAssociatedWithCar(@PathVariable Long carId, @PathVariable Long docId) {
        documentRepository.deleteById(docId);
    }

}



