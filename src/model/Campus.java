package model;

import dao.CampusDAO;
import dao.InstitutionDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
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
    private Institution institution;
    private Long idInstitution;
    private static CampusDAO DAO = new CampusDAO();

    public Institution getInstitution() {
        if (institution == null) {
            InstitutionDAO dao = new InstitutionDAO();
            institution = dao.findOne(idInstitution);
        }
        return institution;
    }

    public Campus setInstitution(Institution institution) {
        if (institution != null) {
            this.idInstitution = institution.getIdInstitution();
        }
        this.institution = institution;
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
