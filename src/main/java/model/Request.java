package model;

import dao.RequestDAO;
import dao.RoomDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    public static Optional<Request> save(Request request) { return DAO.save(request); }

    public static Optional<Request> update(Request request) {
        return DAO.update(request);
    }

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static Request findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Request> findAll() {
        return DAO.findAll();
    }
}