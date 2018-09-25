package dao;

import model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO implements DAO<Event, Long> {
    @Override
    public Boolean save(Event event) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getInsertSQLString(event));
            Query.setStatementValues(
                    statement,
                    event.getIdEvent(),
                    event.getDay(),
                    event.getName(),
                    event.getPeriod().getIdPeriod(),
                    event.getProfessor().getIdProfessor(),
                    event.getRoom().getIdRoom()
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
    public Event find(Long key) {
        String sql = String.format("SELECT * FROM event WHERE id_event = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Event> findAll() {
        return search("SELECT * FROM event");
    }

    @Override
    public Boolean update(Event event) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(event));
            Query.setStatementValues(
                    statement,
                    event.getDay(),
                    event.getName(),
                    event.getPeriod().getIdPeriod(),
                    event.getProfessor().getIdProfessor(),
                    event.getRoom().getIdRoom(),
                    event.getIdEvent()
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
        Event event = new Event();
        event.setIdEvent(result.getLong("id_event"));
        event.setDay(result.getString("day"));
        event.setName(result.getString("name"));
        event.setPeriod(null);
        event.setProfessor(null);
        event.setRoom(null);
        return event;
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
