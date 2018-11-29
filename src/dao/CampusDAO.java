package dao;

import model.Campus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CampusDAO implements DAO<Campus, Long> {
    @Override
    public Optional<Campus> save(Campus campus) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO campus SET " +
                            "name = ?, " +
                            "street = ?, " +
                            "number = ?, " +
                            "city = ?, " +
                            "state = ?, " +
                            "telephone = ?, " +
                            "zip = ?, " +
                            "id_institute = ?"
            );
            Query.setStatementValues(
                    statement,
                    campus.getName(),
                    campus.getStreet(),
                    campus.getNumber(),
                    campus.getCity(),
                    campus.getState(),
                    campus.getTelephone(),
                    campus.getZip(),
                    campus.getIdInstitute()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(campus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Campus findOne(Long key) {
        String sql = String.format("SELECT * FROM campus WHERE id_campus = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Campus> findAll() {
        return search("SELECT * FROM campus");
    }

    @Override
    public Optional<Campus> update(Campus campus) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE campus SET " +
                            "name = ?, " +
                            "street = ?, " +
                            "number = ?, " +
                            "city = ?, " +
                            "state = ?, " +
                            "telephone = ?, " +
                            "zip = ?, " +
                            "id_institute = ? " +
                            "WHERE id_campus = ?"
            );
            Query.setStatementValues(
                    statement,
                    campus.getName(),
                    campus.getStreet(),
                    campus.getNumber(),
                    campus.getCity(),
                    campus.getState(),
                    campus.getTelephone(),
                    campus.getZip(),
                    campus.getIdInstitute(),
                    campus.getIdCampus()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(campus);
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
                    "DELETE FROM campus WHERE id_campus = ?"
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

    private Campus fromResultSet(ResultSet result) throws SQLException {
        return new Campus()
                .setIdCampus(result.getLong("id_campus"))
                .setName(result.getString("name"))
                .setStreet(result.getString("street"))
                .setNumber(result.getLong("number"))
                .setCity(result.getString("city"))
                .setState(result.getString("state"))
                .setTelephone(result.getString("telephone"))
                .setZip(result.getString("zip"))
                .setInstitute(null)
                .setIdInstitute(result.getLong("id_institute"));
    }

    private List<Campus> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Campus> list = new ArrayList<>();
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
