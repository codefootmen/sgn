package model;

import dao.nDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class Building {
    @Id
    @GeneratedValue
    private Long idBuilding;

    private String name;
    private Integer quantityOfBathrooms;
    private Boolean elevator;
    private Boolean accessibility;

    @ManyToOne
    private Campus campus;
    private Long idCampus;

    @ManyToOne
    private Institute institute;
    private Long idInstitute;

    private static nDAO DAO = new nDAO();

    public Campus getCampus() {
        if (campus == null) {
            nDAO dao = new nDAO();
            campus = (Campus) dao.findOne(idCampus, Campus.class);
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
            nDAO dao = new nDAO();
            institute = (Institute) dao.findOne(idInstitute, Institute.class);
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

    public static void delete(Long id) {
        DAO.delete(new Building().setIdBuilding(id));
    }

    public static Building findOne(Long id) {
        return (Building) DAO.findOne(id, Building.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Building.class);
    }

    public static Optional<Building> save(Building building){return DAO.save(building); }

    public static Optional<Building> update(Building building) {
        return DAO.update(building);
    }
}
