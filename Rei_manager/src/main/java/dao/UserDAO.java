package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/user_manager?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "{CALL insert_user(?,?,?)}";
//    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "{CALL get_user_by_id(?)}";
//    private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";
    private static final String ORDER_BY_NAME = "select * from users order by name;";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    protected  PreparedStatement createPreparedStatement(String orderCommand) throws SQLException {
       Connection connection = getConnection();
       return connection.prepareStatement(orderCommand);
    }


//    @Override
//    public void add(User user) throws SQLException {
//        System.out.println(INSERT_USERS_SQL);
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getCountry());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//    }

    @Override
    public void add(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(INSERT_USERS_SQL)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//    @Override
//    public void addUserTransaction(User user, int[] permission) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        PreparedStatement pstmtAssignment = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//            conn.setAutoCommit(false);
//            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
//            pstmt.setString(1, user.getName());
//            pstmt.setString(2, user.getEmail());
//            pstmt.setString(3, user.getCountry());
//            int rowAffected = pstmt.executeUpdate();
//            rs = pstmt.getGeneratedKeys();
//            int userId = 0;
//            if (rs.next())
//                userId = rs.getInt(1);
//            if (rowAffected == 1) {
//                String sqlPivot = "INSERT INTO user_permission(user_id,permission_id) "
//                        + "VALUES(?,?)";
//                pstmtAssignment = conn.prepareStatement(sqlPivot);
//                for (int permissionId : permissions) {
//                    pstmtAssignment.setInt(1, userId);
//                    pstmtAssignment.setInt(2, permissionId);
//                    pstmtAssignment.executeUpdate();
//                }
//                conn.commit();
//            } else {
//                conn.rollback();
//            }
//        } catch (SQLException ex) {
//            try {
//                if (conn != null)
//                    conn.rollback();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//            System.out.println(ex.getMessage());
//        } finally {
//            try {
//                if (rs != null) rs.close();
//                if (pstmt != null) pstmt.close();
//                if (pstmtAssignment != null) pstmtAssignment.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

//    @Override
//    public User findById(int id) {
//        User user = null;
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(id, name, email, country);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return user;
//    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(SELECT_USER_BY_ID)) {
            callableStatement.setInt(1, id);
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        return orderByProperty("default");
    }

    @Override
    public List<User> orderByName() throws SQLException {
        return orderByProperty("name");
    }

    @Override
    public List<User> orderByProperty(String orderCondition) throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        if (orderCondition.equals("default")) {
            preparedStatement = createPreparedStatement(SELECT_ALL_USERS);
        }
        if (orderCondition.equals("name")) {
            preparedStatement = createPreparedStatement(ORDER_BY_NAME);
        }
        assert preparedStatement != null;
        ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        return users;
    }

    @Override
    public List<User> findByName(String word) {
        return findByWord(word, "name");
    }


    @Override
    public List<User> findByCountry(String country) {
        return findByWord(country,"country");
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void update(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void insertStore(User user) throws SQLException {

    }

    public List<User> findByWord(String word, String condition) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                if (condition.equals("name")) {
                    if (name.contains(word)) {
                        users.add(new User(id, name, email, country));
                    }
                }
                if (condition.equals("country")) {
                    if (country.contains(word)) {
                        users.add(new User(id, name, email, country));
                    }
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
}
