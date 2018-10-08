package model;

import dao.RoomDAO;
import lombok.Data;
import lombok.experimental.Accessors;

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
}
