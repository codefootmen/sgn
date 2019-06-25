package model;

import dao.DAO;
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
public class Professor extends Person {
    @Id
    @GeneratedValue
    private Long idProfessor;
    private StatusEnum status;
    private HonorificsEnum honorifics;
    private static dao.DAO DAO = new DAO();


    public Professor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Professor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Professor setEmail(String email) {
        this.email = email;
        return this;
    }

    public Professor setStatus(String status) {
        this.status = StatusEnum.valueOf(status.toUpperCase());
        return this;
    }

    public Professor setHonorifics(String honorifics) {
        this.honorifics = HonorificsEnum.valueOf(honorifics.toUpperCase());
        return this;
    }


    public static void delete(Long id){
        DAO.delete(new Professor().setIdProfessor(id));
    }

    public static Professor findOne(Long id) { return (Professor) DAO.findOne(id, Professor.class); }

    public static List<Object> findAll() {
        return DAO.findAll(Professor.class);
    }

    public static Optional<Professor> save(Professor professor) {
        return DAO.save(professor);
    }

    public static Optional<Professor> update(Professor professor) {
        return DAO.update(professor);
    }


}
