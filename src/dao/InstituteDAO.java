package dao;

import model.Institute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstituteDAO implements DAO<Institute, Long> {

    @Override
    public Optional<Institute> save(Institute institute) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO institute SET " +
                            "name = ?, " +
                            "logo = ?, " +
                            "site = ?"
            );
            Query.setStatementValues(
                    statement,
                    institute.getName(),
                    institute.getLogo(),
                    institute.getSite()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(institute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Institute findOne(Long key) {
        String sql = String.format("SELECT * FROM institute WHERE id_institute = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Institute> findAll() {
        return search("SELECT * FROM institute");
    }

    @Override
    public Optional<Institute> update(Institute institute) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE institute SET " +
                            "name = ?, " +
                            "logo = ?, " +
                            "site = ? " +
                            "WHERE id_institute = ?"
            );
            Query.setStatementValues(
                    statement,
                    institute.getName(),
                    institute.getLogo(),
                    institute.getSite(),
                    institute.getIdInstitute()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(institute);
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
                    "DELETE FROM institute WHERE id_institute = ?"
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

    private Institute fromResultSet(ResultSet result) throws SQLException {
        return new Institute()
                .setIdInstitute(result.getLong("id_institute"))
                .setName(result.getString("name"))
                .setLogo(result.getString("logo"))
                .setSite(result.getString("site"));
    }

    private List<Institute> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Institute> list = new ArrayList<>();
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
