package dao;

import model.Activity;
import model.Period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeriodDAO implements DAO<Period, Long> {
    @Override
    public Optional<Period> save(Period period) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO period SET " +
                            "start = ?, " +
                            "end = ?, " +
                            "day_of_the_week = ?, " +
                            "id_room = ?"
            );
            Query.setStatementValues(
                    statement,
                    period.getStart(),
                    period.getEnd(),
                    period.getDayOfTheWeek(),
                    period.getIdRoom()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(period);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Period findOne(Long key) {
        String sql = String.format("SELECT * FROM period WHERE id_period = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Period> findAll() {
        return search("SELECT * FROM period");
    }

    @Override
    public Optional<Period> update(Period period) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE period SET " +
                            "start = ?, " +
                            "end = ?, " +
                            "day_of_the_week = ?, " +
                            "id_room = ? " +
                            "WHERE id_period = ?"
            );
            Query.setStatementValues(
                    statement,
                    period.getStart(),
                    period.getEnd(),
                    period.getDayOfTheWeek(),
                    period.getIdRoom(),
                    period.getIdPeriod()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(period);
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
                    "DELETE FROM period WHERE id_period = ?"
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

    private Period fromResultSet(ResultSet result) throws SQLException {
        return new Period()
                .setIdPeriod(result.getLong("id_period"))
                .setStart(result.getString("start"))
                .setEnd(result.getString("end"))
                .setDayOfTheWeek(result.getString("day_of_the_week"))
                .setRoom(null)
                .setIdRoom(result.getLong("id_room"));
    }

    private List<Period> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Period> list = new ArrayList<>();
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