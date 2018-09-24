package dao;

import model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public List<Event> findAll() {
        return null;
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
        return null;
    }
}
