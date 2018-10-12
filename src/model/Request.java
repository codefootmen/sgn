package model;

import dao.RequestDAO;
import dao.RoomDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Request {
    private Long idRequest;
    private String motive;
    private String description;
    private PriorityEnum priority;
    private Room room;
    private Long idRoom;

    public Request setPriority(String priority) {
        this.priority = PriorityEnum.valueOf(priority.toUpperCase());
        return this;
    }

    public Room getRoom() {
        if (room == null) {
            RoomDAO dao = new RoomDAO();
            room = dao.findOne(idRoom);
        }
        return room;
    }

    public Request setRoom(Room room) {
        if (room != null) {
            idRoom = room.getIdRoom();
        }
        this.room = room;
        return this;
    }

    public void save() throws SQLException, ClassNotFoundException{
        RequestDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        RequestDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        RequestDAO.delete(this);
    }

    public static Request findOne(idRequest) throws ClassNotFoundException, SQLException{
        return RequestDAO.findOne(idRequest);
    }

    public static List<Request> findAll() throws SQLException, ClassNotFoundException{
        return RequestDAO.findAll();
    }
}
