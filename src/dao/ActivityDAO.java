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
            statement = connection.prepareStatement(
                    "INSERT INTO activity SET " +
                            "name = ? " +
                            "activity_type = ? " +
                            "area = ? " +
                            "id_professor = ?" +
                            "id_campus = ? " +
                            "id_department = ? " +
                            "id_institution = ? " +
                            "id_program = ?"

            );
            Query.setStatementValues(
                    statement,
                    activity.getName(),
                    activity.getActivityType().toString(),
                    activity.getArea(),
                    activity.getIdProfessor(),
                    activity.getIdCampus(),
                    activity.getIdDepartment(),
                    activity.getIdInstitution(),
                    activity.getIdProgram()
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
            statement = connection.prepareStatement(
                    "UPDATE activity SET " +
                            "name = ? " +
                            "activity_type = ? " +
                            "area = ? " +
                            "id_professor = ?" +
                            "id_campus = ? " +
                            "id_department = ? " +
                            "id_institution = ? " +
                            "id_program = ?" +
                            "WHERE id_activity = ?"

            );
            Query.setStatementValues(
                    statement,
                    activity.getName(),
                    activity.getActivityType().toString(),
                    activity.getArea(),
                    activity.getIdProfessor(),
                    activity.getIdCampus(),
                    activity.getIdDepartment(),
                    activity.getIdInstitution(),
                    activity.getIdProgram(),
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
        Activity activity = new Activity();
        activity.setIdActivity(result.getLong("id_activity"));
        activity.setName(result.getString("name"));
        activity.setActivityType(null);
        activity.setArea(result.getString("area"));
        activity.setProfessor(null);
        return activity;
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
