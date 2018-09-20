package dao;

import model.Building;
import model.Campus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingDAO implements DAO<Building, Long> {
    @Override
    public Boolean save(Building building) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO building SET "+
                            "id_building= ?, "+
                            "name = ?, "+
                            "quantityOfBathroom = ?, "+
                            "elevator = ? "+
                            "accessibility = ?, "+
                            "campus = ?, ");

            statement.setLong(1, building.getId());
            statement.setString(2, building.getName());
            statement.setInt(3, building.getQuantityOfBathrooms());
            statement.setBoolean(4, building.getElevator());
            statement.setBoolean(5, building.getAccessibility());
            statement.setObject(6, building.getCampus());
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
    public Building find(Long key) {
        String sql = String.format("SELECT * FROM building WHERE building = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Building> findAll() {
        return search("SELECT * FROM building");
    }

    @Override
    public Boolean update(Building building) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE building SET "+
                            "name = ?, "+
                            "quantityOfBathroom = ?, "+
                            "elevator = ? "+
                            "accessibility = ?, "+
                            "campus = ?, "+
                            "WHERE id_building = ?");

            statement.setString(1, building.getName());
            statement.setInt(2, building.getQuantityOfBathrooms());
            statement.setBoolean(3, building.getElevator());
            statement.setBoolean(4, building.getAccessibility());
            statement.setObject(5, building.getCampus());
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
                    "DELETE FROM building WHERE id_building = ?"
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

    private Building fromResultSet(ResultSet result) throws SQLException {
        return new Building()
                .setId(result.getLong("id_building"))
                .setName(result.getString("name"))
                .setQuantityOfBathrooms(result.getInt("quantityOfBathrooms"))
                .setElevator(result.getBoolean("elevator"))
                .setAccessibility(result.getBoolean("accessibility"))
                .setCampus(new CampusDAO().find(result.getLong("id_campus")));
    }

    private List<Building> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Building> list = new ArrayList<>();
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
