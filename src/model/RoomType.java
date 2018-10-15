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

    public void save() throws SQLException, ClassNotFoundException{
        DAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        DAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        DAO.delete(this.idRoomType);
    }

    public static RoomType findOne(Long id) throws ClassNotFoundException, SQLException{
        return DAO.findOne(id);
    }

    public static List<RoomType> findAll() throws SQLException, ClassNotFoundException{
        return DAO.findAll();
    }

}
