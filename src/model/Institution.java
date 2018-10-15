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
    static private InstitutionDAO DAO = new InstitutionDAO();

    public void save() {
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
    }

    public void delete(){
        DAO.delete(this.idInstitution);
    }

    public static Institution findOne(Long id){
        return DAO.findOne(id);
    }

    public static List<Institution> findAll() {
        return DAO.findAll();
    }
}
