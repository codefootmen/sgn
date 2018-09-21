package test;


import dao.Query;
import model.Activity;
import model.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQL {
    public static void main(String[] args){

        Student stu = new Student();

        stu.setIdStudent(Long.valueOf(1));
        stu.setEmail("saas");
        stu.setFirstName("fdijfjijifd");
        stu.setLastName("jioidjsaijoda");
        stu.setActivity(new Activity().setIdActivity(Long.valueOf(1)));

        PreparedStatement s = Query.getInsertStatement(stu);
        try {
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
