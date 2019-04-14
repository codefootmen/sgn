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
public class Subject {
    @Id
    @GeneratedValue
    private Long idSubject;
    private String name;
    private Integer quantityOfCredits;

    @ManyToOne
    private RoomType roomType;
    private Long idRoomType;

    @ManyToOne
    private Program program;
    private Long idProgram;

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

    public RoomType getRoomType() {
        if (roomType == null) {
            nDAO dao = new nDAO();
            roomType = (RoomType) dao.findOne(idRoomType, RoomType.class);
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
            nDAO dao = new nDAO();
            program = (Program) dao.findOne(idProgram, Program.class);
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
            nDAO dao = new nDAO();
            department = (Department) dao.findOne(idDepartment, Department.class);
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
            nDAO dao = new nDAO();
            campus = (Campus) dao.findOne(idCampus, Campus.class);
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

    public Institute getInstitute() {
        if (institute == null) {
            nDAO dao = new nDAO();
            institute = (Institute) dao.findOne(idInstitute, Institute.class);
        }
        return institute;
    }

    public Subject setInstitute(Institute institute) {
        if (institute != null) {
            this.idInstitute = institute.getIdInstitute();
        }
        this.institute = institute;
        return this;
    }

    public static Optional<Subject> save(Subject subject) {
        return DAO.save(subject);
    }

    public static Optional<Subject> update(Subject subject) {
        return DAO.update(subject);
    }

    public static void delete(Long id){ DAO.delete(new Subject().setIdSubject(id)); }

    public static Subject findOne(Long id) {
        return (Subject) DAO.findOne(id, Subject.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Subject.class);
    }
}
