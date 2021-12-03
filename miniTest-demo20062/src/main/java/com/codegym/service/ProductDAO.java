package com.codegym.service;

import com.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo20062?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Product product) throws SQLException {
//        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id, name, price, quantity) value (?, ?, ?, ?)");) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Product findByID(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int quantity = Integer.parseInt(rs.getString("quantity"));
                product = new Product(id, name, price, quantity);
            }
        } catch (SQLException e) {
//            printSQLException(e);
        }
        return product;

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int quantity = Integer.parseInt(rs.getString("quantity"));
                products.add(new Product(id, name, price, quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findByName(String key) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + key + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int quantity = Integer.parseInt(rs.getString("quantity"));
                products.add(new Product(id, name, price, quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findAllOderByQuantity() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product order by quantity");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int quantity = Integer.parseInt(rs.getString("quantity"));
                products.add(new Product(id, name, price, quantity));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from product where id = ?;");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    @Override
    public void delete1(int id) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update product set name = ?,price= ?, quantity=? where id = ?;");) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
