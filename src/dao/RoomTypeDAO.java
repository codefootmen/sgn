package dao;

import model.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO implements DAO<RoomType, Long> {
    @Override
    public Boolean save(RoomType roomType) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO roomType SET "+
                            "id_roomType= ?, "+
                            "name = ?, "+
                            "description = ?, ");

            statement.setLong(1, roomType.getId());
            statement.setString(2, roomType.getName());
            statement.setString(3, roomType.getDescription());
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
    public RoomType find(Long key) {
        String sql = String.format("SELECT * FROM roomType WHERE roomType = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<RoomType> findAll() {
        return search("SELECT * FROM roomType");
    }

    @Override
    public Boolean update(RoomType roomType) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE roomType SET "+
                            "id_roomType= ?, "+
                            "name = ?, "+
                            "description = ?, "+
                            "WHERE id_roomType = ?");


            statement.setString(1, roomType.getName());
            statement.setString(2, roomType.getDescription());
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
                    "DELETE FROM roomType WHERE id_roomType = ?"
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

    private RoomType fromResultSet(ResultSet result) throws SQLException {
        return new RoomType()
                .setId(result.getLong("id_roomType"))
                .setName(result.getString("name"))
                .setDescription(result.getString("description"));
    }

    private List<RoomType> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<RoomType> list = new ArrayList<>();
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
