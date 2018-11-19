package model;

import dao.CampusDAO;
import dao.DepartmentDAO;
import dao.InstituteDAO;
import dao.MeetingDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class Meeting {
    private Long idMeeting;
    private String day;
    private String time;
    private String agenda;
    private String minutes;
    private Department department;
    private Long idDepartment;
    private Campus campus;
    private Long idCampus;
    private Institute institute;
    private Long idInstitute;
    private static MeetingDAO DAO = new MeetingDAO();

    public Department getDepartment() {
        if (department == null) {
            DepartmentDAO dao = new DepartmentDAO();
            department = dao.findOne(idDepartment);
        }
        return department;
    }

    public Meeting setDepartment(Department department) {
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

    public Meeting setCampus(Campus campus) {
        if (campus != null) {
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

    public Meeting setInstitute(Institute institute) {
        if (institute != null) {
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
        return this;
    }

    public static Optional<Meeting> save(Meeting meeting) {
        return DAO.save(meeting);
    }

    public static Optional<Meeting> update(Meeting meeting) {
        return DAO.update(meeting);
    }

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static Meeting findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Meeting> findAll() {
        return DAO.findAll();
    }
}
