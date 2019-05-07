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
    private Long idDepartment;

    @ManyToOne
    private Campus campus;
    private Long idCampus;

    @ManyToOne
    private Institute institute;
    private Long idInstitute;
    private static dao.DAO DAO = new DAO();

    public Program setAcademicLevel(String academicLevel) {
        this.academicLevel = AcademicLevelEnum.valueOf(academicLevel.toUpperCase());
        return this;
    }

    public Department getDepartment() {
        if (department == null) {
            dao.DAO dao = new DAO();
            department = (Department) dao.findOne(idDepartment, Department.class);
        }
        return department;
    }

    public Program setDepartment(Department department) {
        if (department != null) {
            this.idDepartment = department.getIdDepartment();
        }
        this.department = department;
        return this;
    }

    public Campus getCampus() {
        if (campus == null) {
            dao.DAO dao = new DAO();
            campus = (Campus) dao.findOne(idCampus, Campus.class);
        }
        return campus;
    }

    public Program setCampus(Campus campus) {
        if (campus != null) {
            this.idCampus = campus.getIdCampus();
        }
        this.campus = campus;
        return this;
    }

    public Institute getInstitute() {
        if (institute == null) {
            dao.DAO dao = new DAO();
            institute = (Institute) dao.findOne(idInstitute, Institute.class);
        }
        return institute;
    }

    public Program setInstitute(Institute institute) {
        if (institute != null) {
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
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
