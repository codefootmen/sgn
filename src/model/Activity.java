package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

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

    public Professor getProfessor() {
        if(professor == null){
            ProfessorDAO dao = new ProfessorDAO();
            professor = dao.find(idProfessor);
        }
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.idProfessor = professor.getIdProfessor();
        this.professor = professor;
    }

    public Department getDepartment() {
        if(department == null){
            DepartmentDAO dao = new DepartmentDAO();
            department = dao.find(idDepartment);
        }
        return department;
    }

    public void setDepartment(Department department) {
        this.idDepartment = department.getIdDepartment();
        this.department = department;
    }

    public Campus getCampus() {
        if(campus == null){
            CampusDAO dao = new CampusDAO();
            campus = dao.find(idCampus);
        }
        return campus;
    }

    public void setCampus(Campus campus) {
        this.idCampus = campus.getIdCampus();
        this.campus = campus;
    }

    public Institution getInstitution() {
        if(institution == null){
            InstitutionDAO dao = new InstitutionDAO();
            institution = dao.find(idInstitution);
        }
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.idInstitution = institution.getIdInstitution();
        this.institution = institution;
    }

    public Program getProgram() {
        if(program == null){
            ProgramDAO dao = new ProgramDAO();
            program = dao.find(idProgram);
        }
        return program;
    }

    public void setProgram(Program program) {
        this.idProgram = program.getIdProgram();
        this.program = program;
    }
}
