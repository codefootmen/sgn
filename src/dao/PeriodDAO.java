package dao;

import model.Period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Period find(Long key) {
        return null;
    }

    @Override
    public List<Period> findAll() {
        return null;
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
        return null;
    }
}
