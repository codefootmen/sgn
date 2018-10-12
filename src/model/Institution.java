package model;


import dao.InstitutionDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Institution {
    private Long idInstitution;
    private String name;
    private String logo;
    private String site;

    public void save() throws SQLException, ClassNotFoundException{
        InstitutionDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        InstitutionDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        InstitutionDAO.delete(this);
    }

    public static Institution findOne(idInstitution) throws ClassNotFoundException, SQLException{
        return InstitutionDAO.findOne(idInstitution);
    }

    public static List<Institution> findAll() throws SQLException, ClassNotFoundException{
        return InstitutionDAO.findAll();
    }
}
