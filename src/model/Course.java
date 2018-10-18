package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Course {
    private Long idCourse;
    private Boolean semester;
    private Integer year;
    private Subject subject;
    private Long idSubject;
    private Program program;
    private Long idProgram;
    private Department department;
    private Long idDepartment;
    private Campus campus;
    private Long idCampus;
    private Institute institute;
    private Long idInstitute;
    private Period period;
    private Long idPeriod;
    private Professor professor;
    private Long idProfessor;
    private static CourseDAO DAO = new CourseDAO();

    public Subject getSubject() {
        if(subject == null){
            SubjectDAO dao = new SubjectDAO();
            subject = dao.findOne(idSubject);
        }
        return subject;
    }

    public Course setSubject(Subject subject) {
        if(subject != null){
            this.idSubject = subject.getIdSubject();
        }
        this.subject = subject;
        return this;
    }

    public Program getProgram() {
        if (program == null) {
            ProgramDAO dao = new ProgramDAO();
            program = dao.findOne(idProgram);
        }
        return program;
    }

    public Course setProgram(Program program) {
        if(program != null){
            this.idProgram = program.getIdProgram();
        }
        this.program = program;
        return this;
    }

    public Department getDepartment() {
        if (department == null) {
            DepartmentDAO dao = new DepartmentDAO();
            department = dao.findOne(idDepartment);
        }
        return department;
    }

    public Course setDepartment(Department department) {
        if(department != null){
            this.idDepartment = department.getIdDepartment();
        }
        this.department = department;
        return this;
    }

    public Campus getCampus() {
        if (campus == null) {
            CampusDAO dao = new CampusDAO();
            campus = dao.findOne(idCampus);
        }
        return campus;
    }

    public Course setCampus(Campus campus) {
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

    public Course setInstitute(Institute institute) {
        if(institute != null){
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
        return this;
    }

    public Period getPeriod() {
        if(period == null){
            PeriodDAO dao = new PeriodDAO();
            period = dao.findOne(idPeriod);
        }
        return period;
    }

    public Course setPeriod(Period period) {
        if(period != null){
            this.idPeriod = period.getIdPeriod();
        }
        this.period = period;
        return this;
    }

    public Professor getProfessor() {
        if (professor == null) {
            ProfessorDAO dao = new ProfessorDAO();
            professor = dao.findOne(idProfessor);
        }
        return professor;
    }

    public Course setProfessor(Professor professor) {
        if (professor != null){
            this.idProfessor = professor.getIdProfessor();
        }
        this.professor = professor;
        return this;
    }

    public void save() throws SQLException, ClassNotFoundException{
        DAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        DAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        DAO.delete(this.idCourse);
    }

    public static Course findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Course> findAll() {
        return DAO.findAll();
    }
}
