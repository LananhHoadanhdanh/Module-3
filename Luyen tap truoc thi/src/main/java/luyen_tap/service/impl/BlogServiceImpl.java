package luyen_tap.service.impl;

import luyen_tap.model.Blog;
import luyen_tap.model.Category;
import luyen_tap.service.GeneralService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements GeneralService<Blog> {
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
    public Blog findById(int id) {
        Blog blog = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from blog where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String content = rs.getString("content");
                int categoryId = rs.getInt("categoryId");
                blog = new Blog(id, name, content, categoryId);
            }
        } catch (SQLException ignored) {
        }
        return blog;
    }

    @Override
    public void add(Blog blog) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into blog(name, content, categoryId) values (?, ?, ?)");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, blog.getName());
            preparedStatement.setString(2, blog.getContent());
            preparedStatement.setInt(3, blog.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void edit(Blog blog) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("update blog set name = ?, content = ?, categoryId = ? where id = ?;");) {
            statement.setString(1, blog.getName());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getCategoryId());
            statement.setInt(4, blog.getId());
            statement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from blog where id = ?;");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from blog");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String content = rs.getString("content");
                int quantity = Integer.parseInt(rs.getString("categoryId"));
                blogs.add(new Blog(id, name, content, quantity));
            }
        } catch (SQLException ignored) {
        }
        return blogs;
    }

    @Override
    public List<Blog> findByName() {
        return null;
    }
}
