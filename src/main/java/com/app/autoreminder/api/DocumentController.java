package com.app.autoreminder.api;

import com.app.autoreminder.model.Car;
import com.app.autoreminder.model.Document;
import com.app.autoreminder.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DocumentController {

    private DocumentService documentService;

    public DocumentController() {
        documentService = new DocumentService();
    }

    @GetMapping("/doc")
    public ArrayList<Document> getDocument() {
        return documentService.selectAll();
    }

    @GetMapping("/doc/{id}")
    public Document getDocument(@PathVariable Long id) {
        return documentService.selectById(id);
    }

    @PostMapping("/doc")
    public void postDocument(@RequestBody Document d) {
        documentService.addDocument(d.getCar_id(), d.getName(), d.getExpiration_data());
    }

    @PutMapping("/doc/{id}")
    public void putDocument(@PathVariable Long id, @RequestBody Document d) {
        documentService.modifyById(id, d.getCar_id(), d.getName(), d.getExpiration_data());
    }

    @DeleteMapping("/doc/{id}")
    public void deleteDocument(@PathVariable Long id){
        documentService.deleteById(id);
    }
}



