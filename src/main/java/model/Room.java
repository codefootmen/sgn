package model;

import dao.nDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long idRoom;

    private Integer number;
    private Integer quantityOfSeats;

    @ManyToOne
    private RoomType roomType;
    private Long idRoomType;

    @ManyToOne
    private Building building;
    private Long idBuilding;
    private static nDAO DAO = new nDAO();

    public RoomType getRoomType() {
        if (roomType == null) {
            nDAO dao = new nDAO();
            roomType = (RoomType) dao.findOne(idRoomType, RoomType.class);
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
            nDAO dao = new nDAO();
            building = (Building) dao.findOne(idBuilding, Building.class);
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
        DAO.delete(new Room().setIdRoom(id));
    }

    public static Room findOne(Long id) {
        return (Room) DAO.findOne(id, Room.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Room.class);
    }
}
