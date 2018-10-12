package model;

import dao.CampusDAO;
import dao.DepartmentDAO;
import dao.InstitutionDAO;
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
    private Institution institution;
    private Long idInstitution;
    private Professor professor;
    private Long idProfessor;

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

    public Institution getInstitution() {
        if (institution == null) {
            InstitutionDAO dao = new InstitutionDAO();
            institution = dao.findOne(idInstitution);
        }
        return institution;
    }

    public Department setInstitution(Institution institution) {
        if(institution != null){
            this.idInstitution = institution.getIdInstitution();
        }
        this.institution = institution;
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

    public void save() throws SQLException, ClassNotFoundException{
        DepartmentDAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        DepartmentDAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        DepartmentDAO.delete(this);
    }

    public static Department findOne(idDepartment) throws ClassNotFoundException, SQLException{
        return DepartmentDAO.findOne(idDepartment);
    }

    public static List<Department> findAll() throws SQLException, ClassNotFoundException{
        return DepartmentDAO.findAll();
    }
}
