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
            statement = connection.prepareStatement(Query.getInsertSQLString(program));
            Query.setStatementValues(
                    statement,
                    program.getIdProgram(),
                    program.getName(),
                    program.getDepartment().getIdDepartment()
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
    public Program find(Long key) {
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
            statement = connection.prepareStatement(Query.getUpdateSQLString(program));
            Query.setStatementValues(
                    statement,
                    program.getName(),
                    program.getDepartment(),
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
        Program program = new Program();
        program.setIdProgram(result.getLong("id_program"));
        program.setName(result.getString("name"));
        program.setDepartment(null);
        return program;
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