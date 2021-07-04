package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    SQLConnection sqlConnection = new SQLConnection();
    private String FIND_ALL_QUERY = "SELECT * FROM customer;";
    private String ADD_QUERY = "INSERT INTO customer VALUES (?, ?, ?);";
    private String FIND_BY_ID_QUERY = "SELECT * FROM customer WHERE IDCus = ?";
    private String EDIT_QUERY = "UPDATE customer set name = ?, age =? WHERE idCus = ?";
    private String DELETE_QUERY = "DELETE From customer WHERE idCus = ?";
    private String FIND_BY_NAME_QUERY = "SELECT * FROM customer WHERE name LIKE ?";

    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        List<Customer> customers = new ArrayList<>();
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_QUERY);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idCus = resultSet.getInt("idCus");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            customers.add(new Customer(idCus, name, age));
        }
        return customers;
    }

    public void add(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
        preparedStatement.setInt(1, customer.getIdCus());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setInt(3, customer.getAge());
        preparedStatement.executeUpdate();
    }

    public Customer findById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idCus = resultSet.getInt("idCus");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            return new Customer(idCus, name, age);
        }
        return null;
    }

    public void edit(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT_QUERY);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setInt(2, customer.getAge());
        preparedStatement.setInt(3, customer.getIdCus());
        preparedStatement.executeUpdate();
    }

    public void deleteById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }


    public List<Customer> findByName(String name) throws SQLException, ClassNotFoundException {
        List<Customer> customers = new ArrayList<>();
        Connection connection = sqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME_QUERY);
        preparedStatement.setString(1, "%"+name+"%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idCus = resultSet.getInt("idCus");
            int age = resultSet.getInt("age");
            name = resultSet.getString("name");
            customers.add(new Customer(idCus, name, age));
        }
        return customers;
    }
}

