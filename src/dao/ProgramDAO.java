package dao;

import model.Activity;
import model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgramDAO implements DAO<Program, Long> {
    @Override
    public Optional<Program> save(Program program) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO program SET " +
                            "name = ?, " +
                            "academic_level = ?, " +
                            "id_department = ?, " +
                            "id_campus = ?, " +
                            "id_institute = ?"
            );
            Query.setStatementValues(
                    statement,
                    program.getName(),
                    program.getAcademicLevel().toString(),
                    program.getIdDepartment(),
                    program.getIdCampus(),
                    program.getIdInstitute()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(program);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
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
    public Optional<Program> update(Program program) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE program SET " +
                            "name = ?, " +
                            "academic_level = ?, " +
                            "id_department = ?, " +
                            "id_campus = ?, " +
                            "id_institute = ? " +
                            "WHERE id_program = ?"
            );
            Query.setStatementValues(
                    statement,
                    program.getName(),
                    program.getAcademicLevel().toString(),
                    program.getIdDepartment(),
                    program.getIdCampus(),
                    program.getIdInstitute(),
                    program.getIdProgram()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(program);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.of(program);
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
                .setInstitute(null)
                .setIdInstitute(result.getLong("id_institute"));
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