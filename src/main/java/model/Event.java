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

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Room room;

    private static dao.DAO DAO = new DAO();

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
