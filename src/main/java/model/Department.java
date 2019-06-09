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
public class Department {

    @Id
    @GeneratedValue
    private Long idDepartment;

    private String field;
    private String description;

    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Institute institute;

    @ManyToOne
    private Professor professor;

    private static dao.DAO DAO = new DAO();

    public static void delete(Long id){
        DAO.delete(new Department().setIdDepartment(id));
    }

    public static Department findOne(Long id) { return (Department) DAO.findOne(id, Department.class); }

    public static List<Object> findAll() {
        return DAO.findAll(Department.class);
    }

    public static Optional<Department> save(Department department){return DAO.save(department); }

    public static Optional<Department> update(Department department) {
        return DAO.update(department);
    }
}
