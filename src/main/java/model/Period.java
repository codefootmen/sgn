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
public class Period {
    @Id
    @GeneratedValue
    private Long idPeriod;
    private String start;
    private String end;
    private String dayOfTheWeek;

    @ManyToOne
    private Room room;
    private Long idRoom;

    private static nDAO DAO = new nDAO();

    public Room getRoom() {
        if (room == null) {
            nDAO dao = new nDAO();
            room = (Room) dao.findOne(idRoom, Room.class);
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
        DAO.delete(new Period().setIdPeriod(id));
    }

    public static Period findOne(Long id) {
        return (Period) DAO.findOne(id, Period.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Period.class);
    }
}
