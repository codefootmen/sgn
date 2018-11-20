package model;


import dao.InstituteDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class Institute {
    private Long idInstitute;
    private String name;
    private String site;
    static private InstituteDAO DAO = new InstituteDAO();

    public static Optional<Institute> save(Institute institute) {
        return DAO.update(institute);
    }

    public static Optional<Institute> update(Institute institute) {
        return DAO.update(institute);
    }

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static Institute findOne(Long id){
        return DAO.findOne(id);
    }

    public static List<Institute> findAll() {
        return DAO.findAll();
    }

}
