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
            statement = connection.prepareStatement(Query.getInsertSQLString(meeting));
            Query.setStatementValues(
                    statement,
                    meeting.getIdMeeting(),
                    meeting.getDay(),
                    meeting.getTime(),
                    meeting.getAgenda(),
                    meeting.getMinutes(),
                    meeting.getDepartment().getIdDepartment()
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
    public Meeting find(Long key) {
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
            statement = connection.prepareStatement(Query.getUpdateSQLString(meeting));
            Query.setStatementValues(
                    statement,
                    meeting.getDay(),
                    meeting.getTime(),
                    meeting.getAgenda(),
                    meeting.getMinutes(),
                    meeting.getDepartment().getIdDepartment(),
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
        Meeting meeting = new Meeting();
        meeting.setIdMeeting(result.getLong("id_meeting"));
        meeting.setDay(result.getString("day"));
        meeting.setTime(result.getString("time"));
        meeting.setAgenda(result.getString("agenda"));
        meeting.setMinutes(result.getString("minutes"));
        meeting.setDepartment(null);
        return meeting;
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
