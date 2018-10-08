package dao;

import model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO implements DAO<Program, Long> {
    @Override
    public Boolean save(Program program) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO program SET " +
                            "name = ? " +
                            "academic_level = ? " +
                            "id_department = ? " +
                            "id_campus = ? " +
                            "id_institution = ?"
            );
            Query.setStatementValues(
                    statement,
                    program.getName(),
                    program.getAcademicLevel().toString(),
                    program.getIdDepartment(),
                    program.getIdCampus(),
                    program.getIdInstitution()
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
    public Program findOne(Long key) {
        String sql = String.format("SELECT * FROM program WHERE id_program = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Program> findAll() {
        return search("SELECT * FROM program");
    }

    @Override
    public Boolean update(Program program) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE program SET " +
                            "name = ? " +
                            "academic_level = ? " +
                            "id_department = ? " +
                            "id_campus = ? " +
                            "id_institution = ? "+
                            "WHERE id_program = ?"
            );
            Query.setStatementValues(
                    statement,
                    program.getName(),
                    program.getAcademicLevel().toString(),
                    program.getIdDepartment(),
                    program.getIdCampus(),
                    program.getIdInstitution(),
                    program.getIdProgram()
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
                    "DELETE FROM program WHERE id_program = ?"
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

    private Program fromResultSet(ResultSet result) throws SQLException {
        return new Program()
                .setIdProgram(result.getLong("id_program"))
                .setName(result.getString("name"))
                .setAcademicLevel(result.getString("academic_level"))
                .setDepartment(null)
                .setIdDepartment(result.getLong("id_department"))
                .setCampus(null)
                .setIdCampus(result.getLong("id_campus"))
                .setInstitution(null)
                .setIdInstitution(result.getLong("id_institution"));
    }

    private List<Program> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Program> list = new ArrayList<>();
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