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

    public void save() throws SQLException, ClassNotFoundException{
        PeriodDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        PeriodDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        PeriodDAO.delete(this);
    }

    public static Period findOne(idPeriod) throws ClassNotFoundException, SQLException{
        return PeriodDAO.findOne(idPeriod);
    }

    public static List<Meeting> findAll() throws SQLException, ClassNotFoundException{
        return PeriodDAO.findAll();
    }
}
