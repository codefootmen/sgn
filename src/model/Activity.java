package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Activity {
    private Long idActivity;
    private String name;
    private ActivityTypeEnum activityType;
    private String area;
    private Professor professor;
    private Long idProfessor;
    private Department department;
    private Long idDepartment;
    private Campus campus;
    private Long idCampus;
    private Institution institution;
    private Long idInstitution;
    private Program program;
    private Long idProgram;
    private static ActivityDAO DAO = new ActivityDAO();



    public Professor getProfessor() {
        if (professor == null) {
            ProfessorDAO dao = new ProfessorDAO();
            professor = dao.findOne(idProfessor);
        }
        return professor;
    }

    public Activity setProfessor(Professor professor) {
        if (professor != null){
            this.idProfessor = professor.getIdProfessor();
        }
        this.professor = professor;
        return this;
    }

    public Department getDepartment() {
        if (department == null) {
            DepartmentDAO dao = new DepartmentDAO();
            department = dao.findOne(idDepartment);
        }
        return department;
    }

    public Activity setDepartment(Department department) {
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

    public Activity setCampus(Campus campus) {
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

    public Activity setInstitution(Institution institution) {
        if(institution != null){
            this.idInstitution = institution.getIdInstitution();
        }
        this.institution = institution;
        return this;
    }

    public Program getProgram() {
        if (program == null) {
            ProgramDAO dao = new ProgramDAO();
            program = dao.findOne(idProgram);
        }
        return program;
    }

    public Activity setProgram(Program program) {
        if(program != null){
            this.idProgram = program.getIdProgram();
        }
        this.program = program;
        return this;
    }

    public Activity setActivityType(String activityType) {
        this.activityType = ActivityTypeEnum.valueOf(activityType.toUpperCase());
        return this;
    }

    public static Activity findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Activity> findAll() {
        return DAO.findAll();
    }
}
