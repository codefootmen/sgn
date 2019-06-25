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
public class Subject {

    @Id
    @GeneratedValue
    private Long idSubject;
    private String name;
    private Integer quantityOfCredits;

    @ManyToOne
    private RoomType roomType;

    @ManyToOne
    private Program program;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Institute institute;

    private static dao.DAO DAO = new DAO();

    public static Optional<Subject> save(Subject subject) {
        return DAO.save(subject);
    }

    public static Optional<Subject> update(Subject subject) {
        return DAO.update(subject);
    }

    public static void delete(Long id){ DAO.delete(new Subject().setIdSubject(id)); }

    public static Subject findOne(Long id) {
        return (Subject) DAO.findOne(id, Subject.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Subject.class);
    }
}
