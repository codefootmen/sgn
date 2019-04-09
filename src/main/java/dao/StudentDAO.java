package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAO implements DAO<Student, Long> {
    @Override
    public Optional<Student> save(Student student) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO student SET " +
                            "first_name = ?, " +
                            "last_name = ?, " +
                            "email = ?, " +
                            "id_activity = ?"
            );
            Query.setStatementValues(
                    statement,
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmail(),
                    student.getIdActivity()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Student findOne(Long key) {
        String sql = String.format("SELECT * FROM student WHERE id_student = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Student> findAll() {
        return search("SELECT * FROM student");
    }

    @Override
    public Optional<Student> update(Student student) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE student SET " +
                            "first_name = ?, " +
                            "last_name = ?, " +
                            "email = ?, " +
                            "id_activity = ? " +
                            "WHERE id_student = ?"
            );
            Query.setStatementValues(
                    statement,
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmail(),
                    student.getIdActivity(),
                    student.getIdStudent()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
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
        return new Student()
                .setIdStudent(result.getLong("id_student"))
                .setFirstName(result.getString("first_name"))
                .setLastName(result.getString("last_name"))
                .setEmail(result.getString("email"))
                .setActivity(null)
                .setIdActivity(result.getLong("id_activity"));
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
