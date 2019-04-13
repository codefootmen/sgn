package model;


import dao.InstituteDAO;
import dao.nDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;


@Data
@Accessors(chain = true)
@Entity
public class Institute {

    @Id
    @GeneratedValue
    private Long idInstitute;
    private String name;
    private String site;
    static private InstituteDAO DAO = new InstituteDAO();

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static Institute findOne(Long id){
        nDAO d = new nDAO();
        return (Institute)d.findOne(id, Institute.class);
    }

    public static List<Institute> findAll() {
        return DAO.findAll();
    }

    public static Optional<Institute> save(Institute institute) {
        nDAO d = new nDAO();
        return d.save(institute);
    }

    public static Optional<Institute> update(Institute institute) {
        nDAO d = new nDAO();
        return d.update(institute);
    }
}
