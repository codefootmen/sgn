package model;

import dao.CampusDAO;
import dao.InstitutionDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;

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

    public void save() throws SQLException, ClassNotFoundException{
        CampusDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        CampusDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        CampusDAO.delete(this);
    }

    public static Building findOne(idCampus) throws ClassNotFoundException, SQLException{
        return CampusDAO.findOne(idCampus);
    }

    public static List<Building> findAll() throws SQLException, ClassNotFoundException{
        return CampusDAO.findAll();
    }
}
