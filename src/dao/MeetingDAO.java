package dao;

import model.Meeting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAO implements DAO<Meeting, Long> {
    @Override
    public Boolean save(Meeting meeting) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO meeting SET " +
                            "day = ?, " +
                            "time = ?, " +
                            "minutes = ?, " +
                            "agenda = ?, " +
                            "id_department = ?, " +
                            "id_campus = ?, " +
                            "id_institute = ?"
            );
            Query.setStatementValues(
                    statement,
                    meeting.getDay(),
                    meeting.getTime(),
                    meeting.getMinutes(),
                    meeting.getAgenda(),
                    meeting.getIdDepartment(),
                    meeting.getIdCampus(),
                    meeting.getIdInstitute()
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
    public Meeting findOne(Long key) {
        String sql = String.format("SELECT * FROM meeting WHERE id_meeting = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Meeting> findAll() {
        return search("SELECT * FROM meeting");
    }

    @Override
    public Boolean update(Meeting meeting) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE meeting SET " +
                            "day = ?, " +
                            "time = ?, " +
                            "minutes = ?, " +
                            "agenda = ?, " +
                            "id_department = ?, " +
                            "id_campus = ?, " +
                            "id_institute = ? " +
                            "WHERE id_meeting = ?"
            );
            Query.setStatementValues(
                    statement,
                    meeting.getDay(),
                    meeting.getTime(),
                    meeting.getMinutes(),
                    meeting.getIdDepartment(),
                    meeting.getIdCampus(),
                    meeting.getIdInstitute(),
                    meeting.getIdMeeting()
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
                    "DELETE FROM meeting WHERE id_meeting = ?"
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

    private Meeting fromResultSet(ResultSet result) throws SQLException {
        return new Meeting()
                .setIdMeeting(result.getLong("id_meeting"))
                .setDay(result.getString("day"))
                .setTime(result.getString("time"))
                .setAgenda(result.getString("agenda"))
                .setMinutes(result.getString("minutes"))
                .setDepartment(null)
                .setIdDepartment(result.getLong("id_department"))
                .setCampus(null)
                .setIdCampus(result.getLong("id_campus"))
                .setInstitute(null)
                .setIdInstitute(result.getLong("id_institute"));
    }

    private List<Meeting> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Meeting> list = new ArrayList<>();
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
