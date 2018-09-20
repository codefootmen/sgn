package dao;

import model.Building;
import model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements DAO<Room, Long> {
    @Override
    public Boolean save(Room room) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO room SET "+
                            "id_room= ?, "+
                            "number = ?, "+
                            "quantityOfSeats = ?, "+
                            "building = ? "+
                            "RoomType = ?, ");

            statement.setLong(1, room.getId());
            statement.setInt(2, room.getNumber());
            statement.setInt(3, room.getQuantityOfSeats());
            statement.setObject(4, room.getBuilding());
            statement.setObject(5,room.getRoomType());
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
    public Room find(Long key) {
        String sql = String.format("SELECT * FROM room WHERE room = '%s'", key);
        return search(sql).get(0);
    }

    @Override
    public List<Room> findAll() {
        return search("SELECT * FROM room");
    }

    @Override
    public Boolean update(Room room) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE room SET "+
                            "number = ?, "+
                            "quantityOfSeats = ?, "+
                            "building = ? "+
                            "roomType = ?, "+
                            "WHERE id_room = ?");

            statement.setInt(1, room.getNumber());
            statement.setInt(2, room.getQuantityOfSeats());
            statement.setObject(3, room.getBuilding());
            statement.setObject(4,room.getRoomType());
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
                    "DELETE FROM room WHERE id_room = ?"
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

    private Room fromResultSet(ResultSet result) throws SQLException {
        return new Room()
                .setId(result.getLong("id_room"))
                .setNumber(result.getInt("number"))
                .setQuantityOfSeats(result.getInt("quantityOfSeats"))
                .setBuilding(new BuildingDAO().find(result.getLong("id_building")))
                .setRoomType(new RoomTypeDAO().find(result.getLong("id_roomType")));
    }

    private List<Room> search(String sql) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        List<Room> list = new ArrayList<>();
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
