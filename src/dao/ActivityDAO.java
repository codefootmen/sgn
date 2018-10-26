package dao;

import model.Activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActivityDAO implements DAO<Activity, Long> {
    @Override
    public Optional<Activity> save(Activity activity) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO activity SET " +
                            "name = ?, " +
                            "activity_type = ?, " +
                            "area = ?, " +
                            "id_professor = ?, " +
                            "id_campus = ?, " +
                            "id_department = ?," +
                            "id_institute = ?, " +
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
                    activity.getIdInstitute(),
                    activity.getIdProgram()
            );
//            recuperar o id do banco se necessário e atribuir ao objeto
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    activity.setIdActivity(generatedKeys.getLong(1));
//                } else {
//                    throw new SQLException("Creating user failed, no ID obtained.");
//                }
//            }
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(activity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Activity findOne(Long key) {
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
                            "name = ?, " +
                            "activity_type = ?, " +
                            "area = ?, " +
                            "id_professor = ?, " +
                            "id_campus = ?, " +
                            "id_department = ?, " +
                            "id_institute = ?, " +
                            "id_program = ? " +
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
                    activity.getIdInstitute(),
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
        return new Activity()
                .setIdActivity(result.getLong("id_activity"))
                .setName(result.getString("name"))
                .setActivityType(result.getString("activity_type"))
                .setArea(result.getString("area"))
                .setProfessor(null)
                .setIdProfessor(result.getLong("id_professor"))
                .setCampus(null)
                .setIdCampus(result.getLong("id_campus"))
                .setDepartment(null)
                .setIdDepartment(result.getLong("id_department"))
                .setInstitute(null)
                .setIdInstitute(result.getLong("id_institute"))
                .setProgram(null)
                .setIdProgram(result.getLong("id_program"));
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
