package dao;

import model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventDAO implements DAO<Event, Long> {
    @Override
    public Optional<Event> save(Event event) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO event SET " +
                            "name = ?, " +
                            "date = ?, " +
                            "id_period = ?, " +
                            "id_professor = ?, " +
                            "id_room = ?"
            );
            Query.setStatementValues(
                    statement,
                    event.getName(),
                    event.getDate(),
                    event.getIdPeriod(),
                    event.getIdProfessor(),
                    event.getIdRoom()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(event);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Event findOne(Long key) {
        String sql = String.format("SELECT * FROM event WHERE id_event = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Event> findAll() {
        return search("SELECT * FROM event");
    }

    @Override
    public Optional<Event> update(Event event) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE event SET " +
                            "name = ?, " +
                            "date = ?, " +
                            "id_period = ?, " +
                            "id_professor = ?, " +
                            "id_room = ? " +
                            "WHERE id_event = ?"
            );
            Query.setStatementValues(
                    statement,
                    event.getName(),
                    event.getDate(),
                    event.getIdPeriod(),
                    event.getIdProfessor(),
                    event.getIdRoom(),
                    event.getIdEvent()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(event);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Boolean delete(Long key) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM event WHERE id_event = ?"
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

    private Event fromResultSet(ResultSet result) throws SQLException {
        return new Event()
                .setIdEvent(result.getLong("id_event"))
                .setName(result.getString("name"))
                .setDate(result.getString("date"))
                .setPeriod(null)
                .setIdPeriod(result.getLong("id_period"))
                .setProfessor(null)
                .setIdProfessor(result.getLong("id_professor"))
                .setRoom(null)
                .setIdRoom(result.getLong("id_room"));
    }

    private List<Event> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Event> list = new ArrayList<>();
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
