package dao;

import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = String.format("SELECT * FROM subject WHERE id_subject = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Subject> findAll() {
        return search("SELECT * FROM student");
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
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM subject WHERE id_subject = ?"
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

    private Subject fromResultSet(ResultSet result) throws SQLException {
        Subject subject = new Subject();
        subject.setIdSubject(result.getLong("id_subject"));
        subject.setName(result.getString("name"));
        subject.setQuantityOfCredits(result.getInt("quantity_of_credits"));
        subject.setProgram(null);
        subject.setRoomType(null);
        return subject;
    }

    private List<Subject> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Subject> list = new ArrayList<>();
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
