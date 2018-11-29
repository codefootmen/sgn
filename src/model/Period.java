package model;

import dao.PeriodDAO;
import dao.RoomDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class Period {
    private Long idPeriod;
    private String start;
    private String end;
    private String dayOfTheWeek;
    private Room room;
    private Long idRoom;
    private static PeriodDAO DAO = new PeriodDAO();

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

    public static Optional<Period> save(Period period) {
        return DAO.save(period);
    }

    public static Optional<Period> update(Period period) {
        return DAO.update(period);
    }

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static Period findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Period> findAll() {
        return DAO.findAll();
    }
}
