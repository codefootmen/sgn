package dao;

import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProfessorDAO implements DAO<Professor, Long> {
    @Override
    public Boolean save(Professor professor) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getInsertSQLString(professor));
            Query.setStatementValues(
                    statement,
                    professor.getFirstName(),
                    professor.getLastName(),
                    professor.getEmail(),
                    professor.getIdProfessor(),
                    professor.getHonorifics().toString(),
                    professor.getStatus().toString()
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
    public Professor find(Long key) {
        return null;
    }

    @Override
    public List<Professor> findAll() {
        return null;
    }

    @Override
    public Boolean update(Professor professor) {
        return null;
    }

    @Override
    public Boolean delete(Long key) {
        return null;
    }
}
