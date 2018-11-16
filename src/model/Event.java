package model;

import dao.EventDAO;
import dao.PeriodDAO;
import dao.ProfessorDAO;
import dao.RoomDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Event {
    private Long idEvent;
    private String name;
    private String date;
    private Period period;
    private Long idPeriod;
    private Professor professor;
    private Long idProfessor;
    private Room room;
    private Long idRoom;
    private static EventDAO DAO = new EventDAO();

    public Period getPeriod() {
        if (period == null) {
            PeriodDAO dao = new PeriodDAO();
            period = dao.findOne(idPeriod);
        }
        return period;
    }

    public Event setPeriod(Period period) {
        if (period != null) {
            this.idPeriod = period.getIdPeriod();
        }
        this.period = period;
        return this;
    }

    public Professor getProfessor() {
        if (professor == null) {
            ProfessorDAO dao = new ProfessorDAO();
            professor = dao.findOne(idProfessor);
        }
        return professor;
    }

    public Event setProfessor(Professor professor) {
        if (professor != null) {
            this.idProfessor = professor.getIdProfessor();
        }
        this.professor = professor;
        return this;
    }

    public Room getRoom() {
        if (room == null) {
            RoomDAO dao = new RoomDAO();
            room = dao.findOne(idRoom);
        }
        return room;
    }

    public Event setRoom(Room room) {
        if (room != null) {
            idRoom = room.getIdRoom();
        }
        this.room = room;
        return this;
    }

    public void save(){
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
    }

    public static void delete(Long id){
        DAO.delete(id);
    }

    public static Event findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Event> findAll() {
        return DAO.findAll();
    }
}
