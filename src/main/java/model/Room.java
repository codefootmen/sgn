package model;

import dao.DAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long idRoom;

    private Integer number;
    private Integer quantityOfSeats;

    @ManyToOne
    private RoomType roomType;

    @ManyToOne
    private Building building;

    private static dao.DAO DAO = new DAO();

    public static Optional<Room> save(Room room) {
        return DAO.save(room);
    }

    public static Optional<Room> update(Room room) {
        return DAO.update(room);
    }

    public static void delete(Long id) {
        DAO.delete(new Room().setIdRoom(id));
    }

    public static Room findOne(Long id) {
        return (Room) DAO.findOne(id, Room.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Room.class);
    }
}
