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
            statement = connection.prepareStatement(
                    "INSERT INTO subject SET " +
                            "name = ?, " +
                            "quantity_of_credits = ?, " +
                            "id_room_type = ?, " +
                            "id_program = ?, " +
                            "id_department = ?, " +
                            "id_campus = ?, " +
                            "id_institution = ?"
            );
            Query.setStatementValues(
                    statement,
                    subject.getName(),
                    subject.getQuantityOfCredits(),
                    subject.getIdRoomType(),
                    subject.getIdProgram(),
                    subject.getIdDepartment(),
                    subject.getIdCampus(),
                    subject.getIdInstitution()
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
    public Subject findOne(Long key) {
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
            statement = connection.prepareStatement(
                    "UPDATE subject SET " +
                            "name = ?, " +
                            "quantity_of_credits = ?, " +
                            "id_room_type = ?, " +
                            "id_program = ?, " +
                            "id_department = ?, " +
                            "id_campus = ?, " +
                            "id_institution = ? " +
                            "WHERE id_subject = ?"
            );
            Query.setStatementValues(
                    statement,
                    subject.getName(),
                    subject.getQuantityOfCredits(),
                    subject.getIdRoomType(),
                    subject.getIdProgram(),
                    subject.getIdDepartment(),
                    subject.getIdCampus(),
                    subject.getIdInstitution(),
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
        return new Subject()
                .setIdSubject(result.getLong("id_subject"))
                .setName(result.getString("name"))
                .setQuantityOfCredits(result.getInt("quantity_of_credits"))
                .setRoomType(null)
                .setIdRoomType(result.getLong("id_room_type"))
                .setProgram(null)
                .setIdProgram(result.getLong("id_program"))
                .setDepartment(null)
                .setIdDepartment(result.getLong("id_department"))
                .setCampus(null)
                .setIdCampus(result.getLong("id_campus"))
                .setInstitution(null)
                .setIdInstitution(result.getLong("id_institution"));
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
