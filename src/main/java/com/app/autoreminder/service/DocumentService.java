package com.app.autoreminder.service;

import com.app.autoreminder.model.Document;
import com.app.autoreminder.repository.DocumentRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DocumentService {

    private DocumentRepository documentRepository;

    public DocumentService() {
        this.documentRepository = new DocumentRepository();
    }

    public void addDocument(Long car_id, String name, String expiration_data) {
        documentRepository.insert(car_id, name, expiration_data);
    }

    public ArrayList<Document> selectAll() {
        return documentRepository.selectAll();
    }

    public Document selectById(Long id) {
        return documentRepository.selectById(id);
    }




}
