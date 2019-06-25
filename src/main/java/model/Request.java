package model;

import dao.DAO;
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
public class Request {
    @Id
    @GeneratedValue
    private Long idRequest;
    private String motive;
    private String description;
    private PriorityEnum priority;

    @ManyToOne
    private Room room;

    private static dao.DAO DAO = new DAO();

    public Request setPriority(String priority) {
        this.priority = PriorityEnum.valueOf(priority.toUpperCase());
        return this;
    }


    public static Optional<Request> save(Request request) { return DAO.save(request); }

    public static Optional<Request> update(Request request) {
        return DAO.update(request);
    }

    public static void delete(Long id){
        DAO.delete(new Request().setIdRequest(id));
    }

    public static Request findOne(Long id) {
        return (Request) DAO.findOne(id, Request.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Request.class);
    }
}
