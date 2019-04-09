package model;

import dao.BuildingDAO;
import dao.RoomDAO;
import dao.RoomTypeDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class Room {
    private Long idRoom;
    private Integer number;
    private Integer quantityOfSeats;
    private RoomType roomType;
    private Long idRoomType;
    private Building building;
    private Long idBuilding;
    private static RoomDAO DAO = new RoomDAO();

    public RoomType getRoomType() {
        if (roomType == null) {
            RoomTypeDAO dao = new RoomTypeDAO();
            roomType = dao.findOne(idRoomType);
        }
        return roomType;
    }

    public Room setRoomType(RoomType roomType) {
        if (roomType != null) {
            this.idRoomType = roomType.getIdRoomType();
        }
        this.roomType = roomType;
        return this;
    }

    public Building getBuilding() {
        if (building == null) {
            BuildingDAO dao = new BuildingDAO();
            building = dao.findOne(idBuilding);
        }
        return building;
    }

    public Room setBuilding(Building building) {
        if (building != null) {
            idBuilding = building.getIdBuilding();
        }
        this.building = building;
        return this;
    }

    public static Optional<Room> save(Room room) {
        return DAO.save(room);
    }

    public static Optional<Room> update(Room room) {
        return DAO.update(room);
    }

    public static void delete(Long id) {
        DAO.delete(id);
    }

    public static Room findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Room> findAll() {
        return DAO.findAll();
    }
}
