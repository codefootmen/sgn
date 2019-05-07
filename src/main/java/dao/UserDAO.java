package dao;

import model.Activity;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO{

    public User authenticate(String login, String password){
        String sql = String.format("SELECT * FROM user WHERE login = '%s' AND password = '%s'", login.trim(), password.trim());
        return search(sql).get(0);
    }

    public Optional<User> save(User user) {
        return Optional.empty();
    }

    public User findOne(Long key) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }

    public Optional<User> update(User user) {
        return Optional.empty();
    }

    public Boolean delete(Long key) {
        return null;
    }

    private User fromResultSet(ResultSet result) throws SQLException {
        return new User()
                .setIdUser(result.getLong("id_user"))
                .setLogin(result.getString("login"))
                .setAccessLevel(result.getString("access_level"));
    }

    private List<User> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<User> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) list.add(fromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return list;
    }
}
