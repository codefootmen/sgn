package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

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
            subject = dao.find(idSubject);
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
            program = dao.find(idProgram);
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
            department = dao.find(idDepartment);
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
            campus = dao.find(idCampus);
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
            institution = dao.find(idInstitution);
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
            period = dao.find(idPeriod);
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
            professor = dao.find(idProfessor);
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
}
