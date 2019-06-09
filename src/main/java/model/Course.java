package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long idCourse;

    private Boolean semester;
    private Integer year;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Program program;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Institute institute;

    @ManyToOne
    private Period period;

    @ManyToOne
    private Professor professor;


    private static dao.DAO DAO = new DAO();

    public static void delete(Long id) {
        DAO.delete(new Course().setIdCourse(id));
    }

    public static Course findOne(Long id) {
        return (Course) DAO.findOne(id, Course.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Course.class);
    }

    public static Optional<Course> save(Course course) { return DAO.save(course); }

    public static Optional<Course> update(Course course) { return DAO.update(course); }
}
