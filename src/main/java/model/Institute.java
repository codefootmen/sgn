package model;


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
    static private nDAO DAO = new nDAO();

    public static void delete(Long id){
        DAO.delete(new Institute().setIdInstitute(id));
    }

    public static Institute findOne(Long id){
        return (Institute)DAO.findOne(id, Institute.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Institute.class);
    }

    public static Optional<Institute> save(Institute institute) {
        return DAO.save(institute);
    }

    public static Optional<Institute> update(Institute institute) {
        return DAO.update(institute);
    }
}
