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
            statement = connection.prepareStatement(Query.getInsertSQLString(course));
            Query.setStatementValues(
                    statement,
                    course.getIdCourse(),
                    course.getSemester(),
                    course.getYear(),
                    course.getSubject().getIdSubject(),
                    course.getProfessor().getIdProfessor(),
                    course.getRoom().getIdRoom()
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
    public Course find(Long key) {
        String sql = String.format("SELECT * FROM course WHERE course = '%s'", key);
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
            statement = connection.prepareStatement(Query.getUpdateSQLString(course));
            Query.setStatementValues(
                    statement,
                    course.getSemester(),
                    course.getYear(),
                    course.getSubject().getIdSubject(),
                    course.getProfessor().getIdProfessor(),
                    course.getRoom().getIdRoom(),
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
                .setSubject(new SubjectDAO().find(result.getLong("id_subject")))
                .setProfessor(new ProfessorDAO().find(result.getLong("siape")))
                .setRoom(new RoomDAO().find(result.getLong("id_room")));
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
