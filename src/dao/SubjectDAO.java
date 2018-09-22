package dao;

import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SubjectDAO implements DAO<Subject, Long> {
    @Override
    public Boolean save(Subject subject) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getInsertSQLString(subject));
            Query.setStatementValues(
                    statement,
                    subject.getIdSubject(),
                    subject.getName(),
                    subject.getQuantityOfCredits(),
                    subject.getProgram().getIdProgram(),
                    subject.getRoomType().getIdRoomType()
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
    public Subject find(Long key) {
        return null;
    }

    @Override
    public List<Subject> findAll() {
        return null;
    }

    @Override
    public Boolean update(Subject subject) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(subject));
            Query.setStatementValues(
                    statement,
                    subject.getName(),
                    subject.getQuantityOfCredits(),
                    subject.getProgram().getIdProgram(),
                    subject.getRoomType().getIdRoomType(),
                    subject.getIdSubject()
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
