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

    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Institute institute;

    private static dao.DAO DAO = new DAO();

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
