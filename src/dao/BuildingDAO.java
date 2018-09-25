package dao;

import model.Building;

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
            statement = connection.prepareStatement(Query.getInsertSQLString(building));
            Query.setStatementValues(
                    statement,
                    building.getIdBuilding(),
                    building.getName(),
                    building.getQuantityOfBathrooms(),
                    building.getElevator(),
                    building.getAccessibility(),
                    building.getCampus().getIdCampus()
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
    public Building find(Long key) {
        String sql = String.format("SELECT * FROM building WHERE id_building = '%s'", key);
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
            statement = connection.prepareStatement(Query.getUpdateSQLString(building));
            Query.setStatementValues(
                    statement,
                    building.getName(),
                    building.getQuantityOfBathrooms(),
                    building.getElevator(),
                    building.getAccessibility(),
                    building.getCampus().getIdCampus(),
                    building.getIdBuilding()
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
                .setIdBuilding(result.getLong("id_building"))
                .setName(result.getString("name"))
                .setQuantityOfBathrooms(result.getInt("quantity_of_bathrooms"))
                .setElevator(result.getBoolean("elevator"))
                .setAccessibility(result.getBoolean("accessibility"))
                .setCampus(null);
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
