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
public class Campus {

    @Id
    @GeneratedValue
    private Long idCampus;

    private String name;
    private String street;
    private Long number;
    private String city;
    private String state;
    private String telephone;
    private String zip;

    @ManyToOne
    private Institute institute;

    private Long idInstitute;
    private static nDAO DAO = new nDAO();

    public Institute getInstitute() {
        if (institute == null) {
            nDAO dao = new nDAO();
            institute = (Institute) dao.findOne(idInstitute, Institute.class);
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

    public static void delete(Long id){
        DAO.delete(new Campus().setIdCampus(id));
    }

    public static Campus findOne(Long id) {
        return (Campus)DAO.findOne(id, Campus.class);
    }

    public static List<Object> findAll(){
        return DAO.findAll(Campus.class);
    }

    public static Optional<Campus> save(Campus campus){return DAO.save(campus); }

    public static Optional<Campus> update(Campus campus) {
        return DAO.update(campus);
    }
}
