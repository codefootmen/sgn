package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Subject {
    private Long idSubject;
    private String name;
    private Integer quantityOfCredits;
    private RoomType roomType;
    private Long idRoomType;
    private Program program;
    private Long idProgram;
    private Department department;
    private Long idDepartment;
    private Campus campus;
    private Long idCampus;
    private Institution institution;
    private Long idInstitution;
    private static SubjectDAO DAO = new SubjectDAO();
    public RoomType getRoomType() {
        if (roomType == null) {
            RoomTypeDAO dao = new RoomTypeDAO();
            roomType = dao.findOne(idRoomType);
        }
        return roomType;
    }

    public Subject setRoomType(RoomType roomType) {
        if (roomType != null) {
            this.idRoomType = roomType.getIdRoomType();
        }
        this.roomType = roomType;
        return this;
    }

    public Program getProgram() {
        if (program == null) {
            ProgramDAO dao = new ProgramDAO();
            program = dao.findOne(idProgram);
        }
        return program;
    }

    public Subject setProgram(Program program) {
        if (program != null) {
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

    public Subject setDepartment(Department department) {
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

    public Subject setCampus(Campus campus) {
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

    public Subject setInstitution(Institution institution) {
        if (institution != null) {
            this.idInstitution = institution.getIdInstitution();
        }
        this.institution = institution;
        return this;
    }

    public void save() throws SQLException, ClassNotFoundException{
        DAO.save(this);
    }

    public void update() throws SQLException, ClassNotFoundException{
        DAO.update(this);
    }

    public void delete() throws SQLException, ClassNotFoundException{
        DAO.delete(this.idSubject);
    }

    public static Subject findOne(Long id) throws ClassNotFoundException, SQLException{
        return DAO.findOne(id);
    }

    public static List<Subject> findAll() throws SQLException, ClassNotFoundException{
        return DAO.findAll();
    }
}
