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

    public void save() throws SQLException, ClassNotFoundException{
        RoomTypeDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        RoomTypeDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        RoomTypeDAO.delete(this);
    }

    public static RoomType findOne(idRoomType) throws ClassNotFoundException, SQLException{
        return RoomTypeDAO.findOne(idRoomType);
    }

    public static List<RoomType> findAll() throws SQLException, ClassNotFoundException{
        return RoomTypeDAO.findAll();
    }

}
