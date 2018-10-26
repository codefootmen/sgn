package dao;

import model.Building;
import model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDAO implements DAO<Room, Long> {
    @Override
    public Optional<Room> save(Room room) {
        Connection connection = Database.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO room SET " +
                            "number = ?, " +
                            "quantity_of_seats = ?, " +
                            "id_room_type = ?, " +
                            "id_building = ?"
            );
            Query.setStatementValues(
                    statement,
                    room.getNumber(),
                    room.getQuantityOfSeats(),
                    room.getIdRoomType(),
                    room.getIdBuilding()
            );
            statement.execute();
            Database.closeConnection(connection, statement);
            return Optional.of(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database.closeConnection(connection, statement);
        return Optional.empty();
    }

    @Override
    public Room findOne(Long key) {
        String sql = String.format("SELECT * FROM room WHERE id_room = '%s'", key);
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
                    "UPDATE room SET " +
                            "number = ?, " +
                            "quantity_of_seats = ?, " +
                            "id_room_type = ?, " +
                            "id_building = ? "+
                            "WHERE id_room = ?"
            );
            Query.setStatementValues(
                    statement,
                    room.getNumber(),
                    room.getQuantityOfSeats(),
                    room.getIdRoomType(),
                    room.getIdBuilding(),
                    room.getIdRoom()
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
                .setIdRoom(result.getLong("id_room"))
                .setNumber(result.getInt("number"))
                .setQuantityOfSeats(result.getInt("quantity_of_seats"))
                .setRoomType(null)
                .setIdRoomType(result.getLong("id_room_type"))
                .setBuilding(null)
                .setIdBuilding(result.getLong("id_building"));
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
