package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long idActivity;
    private String name;
    private ActivityTypeEnum activityType;
    private String area;

    @ManyToOne
    private Professor professor;
    private Long idProfessor;

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
    private Program program;
    private Long idProgram;

    private static dao.DAO DAO = new DAO();


    public Professor getProfessor() {
        if (professor == null) {
            dao.DAO dao = new DAO();
            professor = (Professor) dao.findOne(idProfessor, Professor.class);
        }
        return professor;
    }

    public Activity setProfessor(Professor professor) {
        if (professor != null) {
            this.idProfessor = professor.getIdProfessor();
        }
        this.professor = professor;
        return this;
    }

    public Department getDepartment() {
        if (department == null) {
            dao.DAO dao = new DAO();
            department = (Department) dao.findOne(idDepartment, Department.class);
        }
        return department;
    }

    public Activity setDepartment(Department department) {
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

    public Activity setCampus(Campus campus) {
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

    public Activity setInstitute(Institute institute) {
        if (institute != null) {
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
        return this;
    }

    public Program getProgram() {
        if (program == null) {
            dao.DAO dao = new DAO();
            program = (Program) dao.findOne(idProgram, Program.class);
        }
        return program;
    }

    public Activity setProgram(Program program) {
        if (program != null) {
            this.idProgram = program.getIdProgram();
        }
        this.program = program;
        return this;
    }

    public Activity setActivityType(String activityType) {
        this.activityType = ActivityTypeEnum.valueOf(activityType.toUpperCase());
        return this;
    }


    public static void delete(Long id) { DAO.delete(new Activity().setIdActivity(id)); }

    public static Activity findOne(Long id) {
        return (Activity) DAO.findOne(id, Activity.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Activity.class);
    }

    public static Optional<Activity> save(Activity activity) {
        return DAO.save(activity);
    }

    public static Optional<Activity> update(Activity activity) {
        return DAO.update(activity);
    }

}
