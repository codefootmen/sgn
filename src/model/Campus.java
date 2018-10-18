package model;

import dao.CampusDAO;
import dao.InstituteDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Campus {
    private Long idCampus;
    private String name;
    private String street;
    private Long number;
    private String city;
    private String state;
    private String telephone;
    private String zip;
    private Institute institute;
    private Long idInstitute;
    private static CampusDAO DAO = new CampusDAO();

    public Institute getInstitute() {
        if (institute == null) {
            InstituteDAO dao = new InstituteDAO();
            institute = dao.findOne(idInstitute);
        }
        return institute;
    }

    public Campus setInstitute(Institute institute) {
        if (institute != null) {
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
        return this;
    }

    public void save() {
        DAO.save(this);
    }

    public void update() {
        DAO.update(this);
    }

    public void delete(){
        DAO.delete(this.idCampus);
    }

    public static Campus findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Campus> findAll(){
        return DAO.findAll();
    }
}
