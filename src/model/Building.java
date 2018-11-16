package model;

import dao.BuildingDAO;
import dao.CampusDAO;
import dao.InstituteDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    private Institute institute;
    private Long idInstitute;
    private static BuildingDAO DAO = new BuildingDAO();

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

    public Institute getInstitute() {
        if (institute == null) {
            InstituteDAO dao = new InstituteDAO();
            institute = dao.findOne(idInstitute);
        }
        return institute;
    }

    public Building setInstitute(Institute institute) {
        if (institute != null) {
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
        return this;
    }

    public void save(){
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
    }

    public static void delete(Long id) {
        DAO.delete(id);
    }

    public static Building findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Building> findAll() {
        return DAO.findAll();
    }

    public static Optional<Building> save(Building building){return DAO.save(building); }
}
