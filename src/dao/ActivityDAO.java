package dao;

import model.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO implements DAO<Activity, Long> {
    @Override
    public Boolean save(Activity activity) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getInsertSQLString(activity));
            Query.setStatementValues(
                    statement,
                    activity.getIdActivity(),
                    activity.getName(),
                    activity.getActivityType(),
                    activity.getArea(),
                    activity.getProfessor().getIdProfessor()
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
    public Activity find(Long key) {
        String sql = String.format("SELECT * FROM activity WHERE id_activity = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Activity> findAll() {
        return search("SELECT * FROM activity");
    }

    @Override
    public Boolean update(Activity activity) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Query.getUpdateSQLString(activity));
            Query.setStatementValues(
                    statement,
                    activity.getName(),
                    activity.getActivityType(),
                    activity.getArea(),
                    activity.getProfessor().getIdProfessor(),
                    activity.getIdActivity()
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
                    "DELETE FROM activity WHERE id_activity = ?"
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

    private Activity fromResultSet(ResultSet result) throws SQLException {
        return new Activity()
                .setIdActivity(result.getLong("id_activity"))
                .setName(result.getString("name"))
                //.setActivityType(result.getInt("activity_type"))
                .setArea(result.getString("area"))
                .setProfessor(new ProfessorDAO().find(result.getLong("id_professor")));
    }

    private List<Activity> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Activity> list = new ArrayList<>();
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
