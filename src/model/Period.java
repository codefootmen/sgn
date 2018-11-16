package model;

import dao.PeriodDAO;
import dao.RoomDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

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

    public void save(){
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
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
