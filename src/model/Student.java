package model;

import dao.ActivityDAO;
import dao.StudentDAO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.SQLException;
import java.util.List;

@Data
@Accessors(chain = true)
public class Student extends Person {
    private Long idStudent;
    private Activity activity;
    private Long idActivity;
    private static StudentDAO DAO = new StudentDAO();

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
            ActivityDAO dao = new ActivityDAO();
            activity = dao.findOne(idActivity);
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

    public void save(){
        DAO.save(this);
    }

    public void update(){
        DAO.update(this);
    }

    public void delete(){
        DAO.delete(this.idStudent);
    }

    public static Student findOne(Long id) {
        return DAO.findOne(id);
    }

    public static List<Student> findAll() {
        return DAO.findAll();
    }
}
