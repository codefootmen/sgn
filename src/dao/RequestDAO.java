package dao;

import model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestDAO implements DAO<Request, Long> {
    @Override
    public Optional<Request> save(Request request) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO request SET " +
                            "motive = ?, " +
                            "description = ?, " +
                            "priority = ?, " +
                            "id_room = ?"
            );
            Query.setStatementValues(
                    statement,
                    request.getMotive(),
                    request.getDescription(),
                    request.getPriority().toString(),
                    request.getIdRoom()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Request findOne(Long key) {
        String sql = String.format("SELECT * FROM request WHERE id_request = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Request> findAll() {
        return search("SELECT * FROM request");
    }

    @Override
    public Boolean update(Request request) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO request SET " +
                            "motive = ?, " +
                            "description = ?, " +
                            "priority = ?, " +
                            "id_room = ? " +
                            "WHERE id_request = ?"
            );
            Query.setStatementValues(
                    statement,
                    request.getMotive(),
                    request.getDescription(),
                    request.getPriority().toString(),
                    request.getIdRoom(),
                    request.getIdRequest()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return false;
    }

    @Override
    public Boolean delete(Long key) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM request WHERE id_request = ?"
            );
            statement.setLong(1, key);
            statement.execute();
            Database.closeConnection(connection, statement);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return false;
    }

    private Request fromResultSet(ResultSet result) throws SQLException {
        return new Request()
                .setIdRequest(result.getLong("id_request"))
                .setMotive(result.getString("motive"))
                .setDescription(result.getString("description"))
                .setPriority(result.getString("priority"))
                .setRoom(null)
                .setIdRoom(result.getLong("id_room"));
    }

    private List<Request> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Request> list = new ArrayList<>();
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
