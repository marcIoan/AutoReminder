package com.app.autoreminder.repository;


import com.app.autoreminder.model.Document;
import com.mysql.cj.protocol.Resultset;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;

public class DocumentRepository {

    private String host = "jdbc:mysql://localhost:3306/autoreminder";
    private String dbUsername = "root";
    private String dbPassword = "1234";


    public void insert(Long car_id, String name, String expiration_data) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "INSERT INTO documents (car_id, name, expiration_data)" +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, car_id);
            statement.setString(2, name);
            statement.setString(3, expiration_data);

            int row = statement.executeUpdate();

            if (row > 0) {
                System.out.println("A new document has inserted successfully.");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteById(Long id) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);
            String sql = "DELETE FROM documents WHERE id =? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);


            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the document information has deleted.");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void updateById(Long id, Long car_id, String name, String expiration_data) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);
            String sql = "UPDATE documents SET car_id =?, name =?, expiration_data =? WHERE id =? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, car_id);
            statement.setString(2, name);
            statement.setString(3, expiration_data);
            statement.setLong(4, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the document information has been updated");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Document> selectAll() {
        ArrayList<Document> documents = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM documents";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Long userId = result.getLong("id");
                Long car_id = result.getLong("car_id");
                String name = result.getString("name");
                String expiration_data = result.getString("expiration_data");

                Document document = new Document(userId, car_id, name, expiration_data);
                documents.add(document);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return documents;

    }

    public Document selectById(Long identifier) {
        Document document = null;

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM documents WHERE id = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, identifier);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Long id = result.getLong("id");
                Long car_id = result.getLong("car_id");
                String name = result.getString("name");
                String expiration_data = result.getString("expiration_data");

                document = new Document(id, car_id, name, expiration_data);

            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return document;
    }

    public ArrayList<Document> selectByCarId(Long carId) {
        ArrayList<Document> documents = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM documents WHERE car_id = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, carId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Long id = result.getLong("id");
                Long car_id = result.getLong("car_id");
                String name = result.getString("name");
                String expiration_data = result.getString("expiration_data");

                Document document = new Document(id, car_id, name, expiration_data);
                documents.add(document);


            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return documents;
    }
}
