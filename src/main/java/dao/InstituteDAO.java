package dao;

import model.Institute;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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



        return Optional.of(institute);
    }

    @Override
    public Institute findOne(Long key) {
        String sql = String.format("SELECT * FROM Institute WHERE id_institute = '%s'", key);
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
                            "site = ? " +
                            "WHERE id_institute = ?"
            );
            Query.setStatementValues(
                    statement,
                    institute.getName(),
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
