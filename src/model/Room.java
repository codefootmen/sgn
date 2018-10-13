package model;

import dao.BuildingDAO;
import dao.RoomDAO;
import dao.RoomTypeDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

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

    public void save() throws SQLException, ClassNotFoundException{
        RoomDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        RoomDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        RoomDAO.delete(this);
    }

    public static Room findOne(idRoom) throws ClassNotFoundException, SQLException{
        return RoomDAO.findOne(idRoom);
    }

    public static List<Room> findAll() throws SQLException, ClassNotFoundException{
        return RoomDAO.findAll();
    }
}
