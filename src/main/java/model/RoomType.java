package model;

import dao.DAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class RoomType {
    @Id
    @GeneratedValue
    private Long idRoomType;
    private String name;
    private String description;
    private static dao.DAO DAO = new DAO();

    public static Optional<RoomType> save(RoomType roomtype) {
        return DAO.save(roomtype);
    }

    public static Optional<RoomType> update(RoomType roomType) {
        return DAO.update(roomType);
    }

    public static void delete(Long id){
        DAO.delete(new RoomType().setIdRoomType(id));
    }

    public static RoomType findOne(Long id) {
        return (RoomType) DAO.findOne(id, RoomType.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(RoomType.class);
    }

}
