package dao;

import model.Institution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstitutionDAO implements DAO<Institution, Long> {

    @Override
    public Boolean save(Institution institution) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO institution SET cnpj = ?, name = ?, logo = ?, site = ?"
            );
            statement.setLong(1, institution.getIdInstitution());
            statement.setString(2, institution.getName());
            statement.setString(3, institution.getLogo());
            statement.setString(4, institution.getSite());
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
    public Institution find(Long key) {
        String sql = String.format("SELECT * FROM institution WHERE cnpj = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Institution> findAll() {
        return search("SELECT * FROM institution");
    }

    @Override
    public Boolean update(Institution institution) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE institution SET name = ?, logo = ?, site = ? WHERE id_institution = ?"
            );
            statement.setString(1, institution.getName());
            statement.setString(2, institution.getLogo());
            statement.setString(3, institution.getSite());
            statement.setLong(4, institution.getIdInstitution());
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
            statement = connection.prepareStatement("DELETE FROM institution WHERE id_institution = ?");
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

    private Institution fromResultSet(ResultSet result) throws SQLException {
        return new Institution()
                .setIdInstitution(result.getLong("id_institution"))
                .setName(result.getString("name"))
                .setLogo(result.getString("logo"))
                .setSite(result.getString("site"));
    }

    private List<Institution> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Institution> list = new ArrayList<>();
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
