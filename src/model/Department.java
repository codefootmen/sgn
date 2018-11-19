package model;

import dao.CampusDAO;
import dao.DepartmentDAO;
import dao.InstituteDAO;
import dao.ProfessorDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Department {
    private Long idDepartment;
    private String field;
    private String description;
    private Campus campus;
    private Long idCampus;
    private Institute institute;
    private Long idInstitute;
    private Professor professor;
    private Long idProfessor;
    private static DepartmentDAO DAO = new DepartmentDAO();

    public Campus getCampus() {
        if (campus == null) {
            CampusDAO dao = new CampusDAO();
            campus = dao.findOne(idCampus);
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
            InstituteDAO dao = new InstituteDAO();
            institute = dao.findOne(idInstitute);
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
            ProfessorDAO dao = new ProfessorDAO();
            professor = dao.findOne(idProfessor);
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

    public void save(){
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
    }

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static Department findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Department> findAll() {
        return DAO.findAll();
    }
}
