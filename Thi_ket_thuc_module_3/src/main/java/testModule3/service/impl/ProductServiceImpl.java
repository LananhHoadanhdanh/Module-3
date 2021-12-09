package testModule3.service.impl;

import testModule3.model.Product;
import testModule3.service.GeneralService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements GeneralService<Product> {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thi_thuc_hanh_module_3?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("price");
                String color = rs.getString("color");
                int categoryId = rs.getInt("categoryId");
                product = new Product(id, name, price, quantity, color, categoryId);
            }
        } catch (SQLException ignored) {
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
                int price = rs.getInt("price");
                int quantity = rs.getInt("price");
                String color = rs.getString("color");
                int categoryId = rs.getInt("categoryId");
                products.add(new Product(id, name, price, quantity, color, categoryId));
            }
        } catch (SQLException ignored) {
        }
        return products;
    }

    @Override
    public void add(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price, quantity, color, categoryId) values (?, ?, ?, ?, ?)");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from product where id = ?;");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void edit(Product product) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update product set name = ?, price = ?, quantity = ?, color = ?, categoryId = ? where id = ?;");) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setInt(5, product.getCategoryId());
            statement.setInt(6, product.getId());
            statement.executeUpdate();
        } catch (SQLException ignored) {
        }
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
                int price = rs.getInt("price");
                int quantity = rs.getInt("price");
                String color = rs.getString("color");
                int categoryId = rs.getInt("categoryId");
                products.add(new Product(id, name, price, quantity, color, categoryId));
            }
        } catch (SQLException ignored) {
        }
        return products;
    }
}
