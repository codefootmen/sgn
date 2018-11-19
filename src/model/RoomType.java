package model;

import dao.RoomTypeDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class RoomType {
    private Long idRoomType;
    private String name;
    private String description;
    private static RoomTypeDAO DAO = new RoomTypeDAO();

    public static Optional<RoomType> save(RoomType roomtype) {
        return DAO.save(roomtype);
    }

    public static Optional<RoomType> update(RoomType roomType) {
        return DAO.update(roomType);
    }

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static RoomType findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<RoomType> findAll() {
        return DAO.findAll();
    }

}
