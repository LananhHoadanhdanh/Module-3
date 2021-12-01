package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void add(User user) throws SQLException;

    User findById(int id);

    List<User> findAll();

    List<User> findByName(String word);

    List<User> findByCountry(String countryFind);

    void delete(int id) throws SQLException;

    void update(User user) throws SQLException;
}
