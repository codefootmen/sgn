package dao;

import model.Period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodDAO implements DAO<Period, Long> {
    @Override
    public Boolean save(Period period) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getInsertSQLString(period));
            Query.setStatementValues(
                    statement,
                    period.getIdPeriod(),
                    period.getStart(),
                    period.getEnd(),
                    period.getDayOfTheWeek()
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
    public Period findOne(Long key) {
        String sql = String.format("SELECT * FROM period WHERE id_period = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Period> findAll() {
        return search("SELECT * FROM period");
    }

    @Override
    public Boolean update(Period period) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(period));
            Query.setStatementValues(
                    statement,
                    period.getStart(),
                    period.getEnd(),
                    period.getDayOfTheWeek(),
                    period.getIdPeriod()
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
        Period period = new Period();
        period.setIdPeriod(result.getLong("id_period"));
        period.setStart(result.getString("start"));
        period.setEnd(result.getString("end"));
        period.setDayOfTheWeek(result.getString("day_of_the_week"));
        return period;
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