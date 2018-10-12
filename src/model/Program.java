package model;

import dao.CampusDAO;
import dao.DepartmentDAO;
import dao.InstitutionDAO;
import dao.ProgramDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Program {
    private Long idProgram;
    private String name;
    private AcademicLevelEnum academicLevel;
    private Department department;
    private Long idDepartment;
    private Campus campus;
    private Long idCampus;
    private Institution institution;
    private Long idInstitution;

    public Program setAcademicLevel(String academicLevel) {
        this.academicLevel = AcademicLevelEnum.valueOf(academicLevel.toUpperCase());
        return this;
    }

    public Department getDepartment() {
        if (department == null) {
            DepartmentDAO dao = new DepartmentDAO();
            department = dao.findOne(idDepartment);
        }
        return department;
    }

    public Program setDepartment(Department department) {
        if (department != null) {
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

    public Program setCampus(Campus campus) {
        if (campus != null) {
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

    public Program setInstitution(Institution institution) {
        if (institution != null) {
            this.idInstitution = institution.getIdInstitution();
        }
        this.institution = institution;
        return this;
    }

    public void save() throws SQLException, ClassNotFoundException{
        ProgramDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        ProgramDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        ProgramDAO.delete(this);
    }

    public static Program findOne(idProgram) throws ClassNotFoundException, SQLException{
        return ProgramDAO.findOne(idProgram);
    }

    public static List<Program> findAll() throws SQLException, ClassNotFoundException{
        return ProgramDAO.findAll();
    }
}
