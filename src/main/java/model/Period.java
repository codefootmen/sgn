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
public class Period {
    @Id
    @GeneratedValue
    private Long idPeriod;
    private String start;
    private String end;
    private String dayOfTheWeek;

    @ManyToOne
    private Room room;

    private static dao.DAO DAO = new DAO();


    public static Optional<Period> save(Period period) {
        return DAO.save(period);
    }

    public static Optional<Period> update(Period period) {
        return DAO.update(period);
    }

    public static void delete(Long id){
        DAO.delete(new Period().setIdPeriod(id));
    }

    public static Period findOne(Long id) {
        return (Period) DAO.findOne(id, Period.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Period.class);
    }
}
