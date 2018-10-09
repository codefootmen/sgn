package dao;

import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements DAO<Course, Long> {
    @Override
    public Boolean save(Course course) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO course SET " +
                            "semester = ?, " +
                            "year = ?, " +
                            "id_subject = ?, " +
                            "id_program = ?, " +
                            "id_department = ?, " +
                            "id_campus = ?, " +
                            "id_institution = ?, " +
                            "id_period = ?, " +
                            "id_professor = ?"
            );
            Query.setStatementValues(
                    statement,
                    course.getSemester(),
                    course.getYear(),
                    course.getIdSubject(),
                    course.getIdProgram(),
                    course.getIdDepartment(),
                    course.getIdCampus(),
                    course.getIdInstitution(),
                    course.getIdPeriod(),
                    course.getIdProfessor()
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
    public Course findOne(Long key) {
        String sql = String.format("SELECT * FROM course WHERE id_course = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Course> findAll() {
        return search("SELECT * FROM course");
    }

    @Override
    public Boolean update(Course course) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE course SET " +
                            "semester = ? " +
                            "year = ? " +
                            "id_subject = ? " +
                            "id_program = ?" +
                            "id_department = ? " +
                            "id_campus = ? " +
                            "id_institution = ? " +
                            "id_period = ? " +
                            "id_professor = ? " +
                            "WHERE id_course = ?"
            );
            Query.setStatementValues(
                    statement,
                    course.getSemester(),
                    course.getYear(),
                    course.getIdSubject(),
                    course.getIdProgram(),
                    course.getIdDepartment(),
                    course.getIdCampus(),
                    course.getIdInstitution(),
                    course.getIdPeriod(),
                    course.getIdProfessor(),
                    course.getIdCourse()
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
                    "DELETE FROM course WHERE id_course = ?"
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

    private Course fromResultSet(ResultSet result) throws SQLException {
        return new Course()
                .setIdCourse(result.getLong("id_course"))
                .setSemester(result.getBoolean("semester"))
                .setYear(result.getInt("year"))
                .setSubject(null)
                .setIdSubject(result.getLong("id_subject"))
                .setProgram(null)
                .setIdProgram(result.getLong("id_program"))
                .setDepartment(null)
                .setIdDepartment(result.getLong("id_department"))
                .setCampus(null)
                .setIdCampus(result.getLong("id_campus"))
                .setInstitution(null)
                .setIdInstitution(result.getLong("id_institution"))
                .setPeriod(null)
                .setIdPeriod(result.getLong("id_period"))
                .setProfessor(null)
                .setIdProfessor(result.getLong("id_professor"));
    }

    private List<Course> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Course> list = new ArrayList<>();
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
