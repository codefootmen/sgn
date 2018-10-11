package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;

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
    private Institution institution;
    private Long idInstitution;
    private Period period;
    private Long idPeriod;
    private Professor professor;
    private Long idProfessor;

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

    public Institution getInstitution() {
        if (institution == null) {
            InstitutionDAO dao = new InstitutionDAO();
            institution = dao.findOne(idInstitution);
        }
        return institution;
    }

    public Course setInstitution(Institution institution) {
        if(institution != null){
            this.idInstitution = institution.getIdInstitution();
        }
        this.institution = institution;
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
        CourseDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        CourseDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        CourseDAO.delete(this);
    }

    public static Building findOne(idCourse) throws ClassNotFoundException, SQLException{
        return CourseDAO.findOne(idCourse);
    }

    public static List<Building> findAll() throws SQLException, ClassNotFoundException{
        return CourseDAO.findAll();
    }
}
