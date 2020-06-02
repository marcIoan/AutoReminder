package com.app.autoreminder.repository;

import com.app.autoreminder.model.Car;
import org.springframework.util.ResourceUtils;

import java.sql.*;
import java.util.ArrayList;

public class CarRepository {

    private String host = "jdbc:mysql://localhost:3306/autoreminder";
    private String dbUsername = "root";
    private String dbPassword = "1234";


    public void insert(String name, String model, String year, String email) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "INSERT INTO car (name, model, year, email)" +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, model);
            statement.setString(3, year);
            statement.setString(4, email);

            int row = statement.executeUpdate();

            if (row > 0) {
                System.out.println("A new car has inserted successfully");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);
            String sql = "DELETE FROM car WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int row = statement.executeUpdate();

            if (row > 0) {
                System.out.println("the car's information has been deleted. ");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateById(int id, String name, String model, String year, String email) {
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE car SET name=?, model=?, year=?, email=?  WHERE id =?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, model);
            statement.setString(3, year);
            statement.setString(4, email);
            statement.setInt(5, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the car information has been updated.");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Car> selectAll() {
        ArrayList<Car> cars = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM car";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Long userId = result.getLong("id");
                String name = result.getString("name");
                String model = result.getString("model");
                String year = result.getString("year");
                String email = result.getString("email");

                Car car = new Car(userId, name, model, year, email);
                cars.add(car);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    public Car selectById(Long id) {
        Car car = null;

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM car WHERE id =? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();


            if (result.next()) {
                Long identifier = result.getLong("id");
                String name = result.getString("name");
                String model = result.getString("model");
                String year = result.getString("year");
                String email = result.getString("email");

                car = new Car(identifier,name,model,year,email);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return car;
    }
}
