package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = String.format("SELECT * FROM student WHERE id_student = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Student> findAll() {
        return search("SELECT * FROM student");
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
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM student WHERE id_student = ?"
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

    private Student fromResultSet(ResultSet result) throws SQLException {
        Student student = new Student();
        student.setFirstName(result.getString("first_name"));
        student.setLastName(result.getString("last_name"));
        student.setEmail(result.getString("email"));
        student.setIdStudent(result.getLong("id_student"));
        student.setActivity(null);
        return student;
    }

    private List<Student> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Student> list = new ArrayList<>();
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
