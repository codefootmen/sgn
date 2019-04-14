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
public class Meeting {
    @Id
    @GeneratedValue
    private Long idMeeting;
    private String day;
    private String time;
    private String agenda;
    private String minutes;

    @ManyToOne
    private Department department;
    private Long idDepartment;

    @ManyToOne
    private Campus campus;
    private Long idCampus;

    @ManyToOne
    private Institute institute;
    private Long idInstitute;

    private static nDAO DAO = new nDAO();

    public Department getDepartment() {
        if (department == null) {
            nDAO dao = new nDAO();
            department = (Department) dao.findOne(idDepartment, Department.class);
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
            nDAO dao = new nDAO();
            campus = (Campus) dao.findOne(idCampus, Campus.class);
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
            nDAO dao = new nDAO();
            institute = (Institute) dao.findOne(idInstitute, Institute.class);
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

    public static void delete(Long id){
        DAO.delete(new Meeting().setIdMeeting(id));
    }

    public static Meeting findOne(Long id) {
        return (Meeting) DAO.findOne(id, Meeting.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Meeting.class);
    }

    public static Optional<Meeting> save(Meeting meeting) { return DAO.save(meeting); }

    public static Optional<Meeting> update(Meeting meeting) { return DAO.update(meeting); }
}
