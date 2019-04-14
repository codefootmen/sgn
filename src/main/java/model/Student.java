package model;

import dao.nDAO;
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
public class Student extends Person {
    @Id
    @GeneratedValue
    private Long idStudent;

    @ManyToOne
    private Activity activity;
    private Long idActivity;

    private static nDAO DAO = new nDAO();

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public Activity getActivity() {
        if (activity == null) {
            nDAO dao = new nDAO();
            activity = (Activity) dao.findOne(idActivity, Activity.class);
        }
        return activity;
    }

    public Student setActivity(Activity activity) {
        if (activity != null) {
            idActivity = activity.getIdActivity();
        }
        this.activity = activity;
        return this;
    }

    public static Optional<Student> save(Student student) { return DAO.save(student); }

    public static Optional<Student> update(Student student) {
        return DAO.update(student);
    }

    public static void delete(Long id){
        DAO.delete(new Student().setIdStudent(id));
    }

    public static Student findOne(Long id) {
        return (Student) DAO.findOne(id, Student.class);
    }

    public static List<Object> findAll() {
        return DAO.findAll(Student.class);
    }
}
