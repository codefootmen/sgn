package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO implements DAO<Student, Long> {
    @Override
    public Boolean save(Student student) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getInsertSQLString(student));
            Query.setStatementValues(
                    statement,
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmail(),
                    student.getIdStudent(),
                    student.getActivity().getIdActivity()
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
    public Student find(Long key) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Boolean update(Student student) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(student));
            Query.setStatementValues(
                    statement,
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmail(),
                    student.getActivity().getIdActivity(),
                    student.getIdStudent()
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
