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
public class Event {
    @Id
    @GeneratedValue
    private Long idEvent;

    private String name;
    private String date;

    @ManyToOne
    private Period period;
    private Long idPeriod;

    @ManyToOne
    private Professor professor;
    private Long idProfessor;

    @ManyToOne
    private Room room;
    private Long idRoom;

    private static dao.DAO DAO = new DAO();

    public Period getPeriod() {
        if (period == null) {
            dao.DAO dao = new DAO();
            period = (Period) dao.findOne(idPeriod, Period.class);
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
            dao.DAO dao = new DAO();
            professor = (Professor) dao.findOne(idProfessor, Professor.class);
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
            dao.DAO dao = new DAO();
            room = (Room) dao.findOne(idRoom, Room.class);
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

    public static void delete(Long id){
        DAO.delete(new Event().setIdEvent(id));
    }

    public static Event findOne(Long id) {
        return (Event) DAO.findOne(id, Event.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Event.class);
    }

    public static Optional<Event> save(Event event) {
        return DAO.save(event);
    }

    public static Optional<Event> update(Event event) {
        return DAO.update(event);
    }
}
