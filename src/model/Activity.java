package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;

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
    private Institute institute;
    private Long idInstitute;
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

    public Institute getInstitute() {
        if (institute == null) {
            InstituteDAO dao = new InstituteDAO();
            institute = dao.findOne(idInstitute);
        }
        return institute;
    }

    public Activity setInstitute(Institute institute) {
        if(institute != null){
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
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

    public static Optional<Activity> save(Activity activity){return DAO.save(activity); }
}
