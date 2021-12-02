package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void add(User user) throws SQLException;

//    void addUserTransaction(User user, int[] permission);

    User findById(int id);

    List<User> findAll() throws SQLException;

    List<User> orderByName() throws SQLException;

    List<User> orderByProperty(String conditionOrder) throws SQLException;

    List<User> findByName(String word);

    List<User> findByCountry(String countryFind);

    void delete(int id) throws SQLException;

    void update(User user) throws SQLException;

    void insertStore(User user) throws SQLException;
}
