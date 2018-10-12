package model;

import dao.ProfessorDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Professor extends Person {
    private Long idProfessor;
    private StatusEnum status;
    private HonorificsEnum honorifics;

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

    public void save() throws SQLException, ClassNotFoundException{
        ProfessorDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        ProfessorDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        ProfessorDAO.delete(this);
    }

    public static Professor findOne(idProfessor) throws ClassNotFoundException, SQLException{
        return ProfessorDAO.findOne(idProfessor);
    }

    public static List<Professor> findAll() throws SQLException, ClassNotFoundException{
        return ProfessorDAO.findAll();
    }
}
