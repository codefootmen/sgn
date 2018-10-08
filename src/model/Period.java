package model;

import dao.RoomDAO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Period {
    private Long idPeriod;
    private String start;
    private String end;
    private String dayOfTheWeek;
    private Room room;
    private Long idRoom;

    public Room getRoom() {
        if (room == null) {
            RoomDAO dao = new RoomDAO();
            room = dao.findOne(idRoom);
        }
        return room;
    }

    public Period setRoom(Room room) {
        if (room != null) {
            idRoom = room.getIdRoom();
        }
        this.room = room;
        return this;
    }
}
