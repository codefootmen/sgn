package model;

import dao.DAO;
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

    private static dao.DAO DAO = new DAO();

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
