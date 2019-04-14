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
    private Long idSubject;

    @ManyToOne
    private Program program;
    private Long idProgram;

    @ManyToOne
    private Department department;
    private Long idDepartment;

    @ManyToOne
    private Campus campus;
    private Long idCampus;

    @ManyToOne
    private Institute institute;
    private Long idInstitute;

    @ManyToOne
    private Period period;
    private Long idPeriod;

    @ManyToOne
    private Professor professor;
    private Long idProfessor;

    private static nDAO DAO = new nDAO();

    public Subject getSubject() {
        if(subject == null){
            nDAO dao = new nDAO();
            subject = (Subject) dao.findOne(idSubject, Subject.class);
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
            nDAO dao = new nDAO();
            program = (Program) dao.findOne(idProgram, Program.class);
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
            nDAO dao = new nDAO();
            department = (Department) dao.findOne(idDepartment, Department.class);
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
            nDAO dao = new nDAO();
            campus = (Campus) dao.findOne(idCampus, Campus.class);
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
            nDAO dao = new nDAO();
            institute = (Institute) dao.findOne(idInstitute, Institute.class);
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
            nDAO dao = new nDAO();
            period = (Period) dao.findOne(idPeriod, Period.class);
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
            nDAO dao = new nDAO();
            professor = (Professor) dao.findOne(idProfessor, Professor.class);
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
