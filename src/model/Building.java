package model;

import dao.BuildingDAO;
import dao.CampusDAO;
import dao.InstitutionDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Building {
    private Long idBuilding;
    private String name;
    private Integer quantityOfBathrooms;
    private Boolean elevator;
    private Boolean accessibility;
    private Campus campus;
    private Long idCampus;
    private Institution institution;
    private Long idInstitution;

    public Campus getCampus() {
        if (campus == null) {
            CampusDAO dao = new CampusDAO();
            campus = dao.findOne(idCampus);
        }
        return campus;
    }

    public Building setCampus(Campus campus) {
        if (campus != null) {
            this.idCampus = campus.getIdCampus();
        }
        this.campus = campus;
        return this;
    }

    public Institution getInstitution() {
        if (institution == null) {
            InstitutionDAO dao = new InstitutionDAO();
            institution = dao.findOne(idInstitution);
        }
        return institution;
    }

    public Building setInstitution(Institution institution) {
        if (institution != null) {
            this.idInstitution = institution.getIdInstitution();
        }
        this.institution = institution;
        return this;
    }

    public void save() throws SQLException, ClassNotFoundException{
        BuildingDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        BuildingDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        BuildingDAO.delete(this);
    }

    public static Building findOne(idBuilding) throws ClassNotFoundException, SQLException{
        return BuildingDAO.findOne(idBuilding);
    }

    public static List<Building> findAll() throws SQLException, ClassNotFoundException{
        return BuildingDAO.findAll();
    }
}
