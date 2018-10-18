package model;


import dao.InstituteDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Institute {
    private Long idInstitute;
    private String name;
    private String logo;
    private String site;
    static private InstituteDAO DAO = new InstituteDAO();

    public void save() {
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
    }

    public void delete(){
        DAO.delete(this.idInstitute);
    }

    public static Institute findOne(Long id){
        return DAO.findOne(id);
    }

    public static List<Institute> findAll() {
        return DAO.findAll();
    }
}
