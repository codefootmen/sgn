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
    private static RequestDAO DAO = new RequestDAO();

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
        DAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        DAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        DAO.delete(this.idRequest);
    }

    public static Request findOne(Long id) throws ClassNotFoundException, SQLException{
        return DAO.findOne(id);
    }

    public static List<Request> findAll() throws SQLException, ClassNotFoundException{
        return DAO.findAll();
    }
}
