package dao;

import model.Program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProgramDAO implements DAO<Program, Long>{
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
        return null;
    }

    @Override
    public List<Program> findAll() {
        return null;
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
        return null;
    }
}
