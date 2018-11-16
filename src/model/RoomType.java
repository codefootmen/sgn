package model;

import dao.RoomTypeDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class RoomType {
    private Long idRoomType;
    private String name;
    private String description;
    private static RoomTypeDAO DAO = new RoomTypeDAO();

    public void save(){
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
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
