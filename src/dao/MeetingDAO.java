package dao;

import model.Meeting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public List<Meeting> findAll() {
        return null;
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
        return null;
    }
}
