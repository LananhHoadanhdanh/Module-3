package luyen_tap.service.impl;

import luyen_tap.model.Blog;
import luyen_tap.model.Category;
import luyen_tap.service.GeneralService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements GeneralService<Category> {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/luyen_tap_truoc_thi?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException ignored) {
        }
        return category;
    }

    @Override
    public void add(Category category) {

    }

    @Override
    public void edit(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from category");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException ignored) {
        }
        return categories;
    }

    @Override
    public List<Category> findByName() {
        return null;
    }
}
