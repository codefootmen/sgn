package dao;

import model.Campus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampusDAO implements DAO<Campus, Long> {
    @Override
    public Boolean save(Campus campus) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO campus SET "+
                            "id_campus = ?, "+
                            "name = ?, "+
                            "street = ?, "+
                            "number = ? "+
                            "city = ?, "+
                            "state = ?, "+
                            "telephone = ?, "+
                            "zip = ?, "+
                            "cnpj = ?"
            );
            statement.setLong(1, campus.getId());
            statement.setString(2, campus.getName());
            statement.setString(3, campus.getStreet());
            statement.setLong(4, campus.getNumber());
            statement.setString(5, campus.getCity());
            statement.setString(6, campus.getState());
            statement.setString(7, campus.getTelephone());
            statement.setString(8, campus.getZip());
            statement.setLong(9, campus.getInstitution().getCnpj());
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
    public Campus find(Long key) {
        String sql = String.format("SELECT * FROM campus WHERE id_campus = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Campus> findAll() {
        return search("SELECT * FROM campus");
    }

    @Override
    public Boolean update(Campus campus) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE campus SET "+
                            "name = ?, "+
                            "street = ?, "+
                            "number = ? "+
                            "city = ?, "+
                            "state = ?, "+
                            "telephone = ?, "+
                            "zip = ?, "+
                            "cnpj = ?"+
                            "WHERE id_campus = ?"
            );
            statement.setString(1, campus.getName());
            statement.setString(2, campus.getStreet());
            statement.setLong(3,campus.getNumber());
            statement.setString(4, campus.getCity());
            statement.setString(5, campus.getState());
            statement.setString(6, campus.getTelephone());
            statement.setString(7, campus.getZip());
            statement.setLong(8, campus.getInstitution().getCnpj());
            statement.setLong(9, campus.getId());
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
                .setId(result.getLong("id_campus"))
                .setName(result.getString("name"))
                .setStreet(result.getString("street"))
                .setNumber(result.getLong("number"))
                .setCity(result.getString("city"))
                .setState(result.getString("state"))
                .setTelephone(result.getString("telephone"))
                .setZip(result.getString("zip"))
                .setInstitution(new InstitutionDAO().find(result.getLong("cnpj")));
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
