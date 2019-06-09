package model;

import dao.*;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long idActivity;
    private String name;
    private ActivityTypeEnum activityType;
    private String area;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Campus campus;

    @ManyToOne
    private Institute institute;

    @ManyToOne
    private Program program;

    private static dao.DAO DAO = new DAO();

    public Activity setActivityType(String activityType) {
        this.activityType = ActivityTypeEnum.valueOf(activityType.toUpperCase());
        return this;
    }


    public static void delete(Long id) { DAO.delete(new Activity().setIdActivity(id)); }

    public static Activity findOne(Long id) {
        return (Activity) DAO.findOne(id, Activity.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Activity.class);
    }

    public static Optional<Activity> save(Activity activity) {
        return DAO.save(activity);
    }

    public static Optional<Activity> update(Activity activity) {
        return DAO.update(activity);
    }

}
