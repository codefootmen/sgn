package model;

import dao.nDAO;
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
    private Long idCampus;

    @ManyToOne
    private Institute institute;
    private Long idInstitute;

    @ManyToOne
    private Professor professor;
    private Long idProfessor;

    private static nDAO DAO = new nDAO();

    public Campus getCampus() {
        if (campus == null) {
            nDAO dao = new nDAO();
            campus = (Campus) dao.findOne(idCampus, Campus.class);
        }
        return campus;
    }

    public Department setCampus(Campus campus) {
        if(campus != null){
            this.idCampus = campus.getIdCampus();
        }
        this.campus = campus;
        return this;
    }

    public Institute getInstitute() {
        if (institute == null) {
            nDAO dao = new nDAO();
            institute = (Institute) dao.findOne(idInstitute, Institute.class);
        }
        return institute;
    }

    public Department setInstitute(Institute institute) {
        if(institute != null){
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
        return this;
    }

    public Professor getProfessor() {
        if (professor == null) {
            nDAO dao = new nDAO();
            professor = (Professor) dao.findOne(idProfessor, Professor.class);
        }
        return professor;
    }

    public Department setProfessor(Professor professor) {
        if (professor != null){
            this.idProfessor = professor.getIdProfessor();
        }
        this.professor = professor;
        return this;
    }

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
