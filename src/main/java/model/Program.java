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
public class Program {

    @Id
    @GeneratedValue
    private Long idProgram;
    private String name;
    private AcademicLevelEnum academicLevel;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Institute institute;
    private static dao.DAO DAO = new DAO();

    public Program setAcademicLevel(String academicLevel) {
        this.academicLevel = AcademicLevelEnum.valueOf(academicLevel.toUpperCase());
        return this;
    }

    public static Optional<Program> save(Program program) {
        return DAO.save(program);
    }

    public static Optional<Program> update(Program program) {
        return DAO.update(program);
    }

    public static void delete(Long id){
        DAO.delete(new Program().setIdProgram(id));
    }

    public static Program findOne(Long id) {
        return (Program) DAO.findOne(id, Program.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Program.class);
    }
}
