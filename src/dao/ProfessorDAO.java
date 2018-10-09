package dao;

import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements DAO<Professor, Long> {
    @Override
    public Boolean save(Professor professor) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO professor SET " +
                            "first_name = ?, " +
                            "last_name = ?, " +
                            "email = ?, " +
                            "status = ?, " +
                            "honorifics = ?"
            );
            Query.setStatementValues(
                    statement,
                    professor.getFirstName(),
                    professor.getLastName(),
                    professor.getEmail(),
                    professor.getStatus().toString(),
                    professor.getHonorifics().toString()
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
    public Professor findOne(Long key) {
        String sql = String.format("SELECT * FROM professor WHERE id_professor = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Professor> findAll() {
        return search("SELECT * FROM professor");
    }

    @Override
    public Boolean update(Professor professor) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE professor SET " +
                            "first_name = ?, " +
                            "last_name = ?, " +
                            "email = ?, " +
                            "status = ?, " +
                            "honorifics = ? " +
                            "WHERE id_professor = ?"
            );
            Query.setStatementValues(
                    statement,
                    professor.getFirstName(),
                    professor.getLastName(),
                    professor.getEmail(),
                    professor.getStatus().toString(),
                    professor.getHonorifics().toString(),
                    professor.getIdProfessor()
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
                    "DELETE FROM professor WHERE id_professor = ?"
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

    private Professor fromResultSet(ResultSet result) throws SQLException {
        return new Professor()
                .setIdProfessor(result.getLong("id_professor"))
                .setFirstName(result.getString("first_name"))
                .setLastName(result.getString("last_name"))
                .setEmail(result.getString("email"))
                .setStatus(result.getString("status"))
                .setHonorifics(result.getString("honorifics"));
    }

    private List<Professor> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Professor> list = new ArrayList<>();
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
