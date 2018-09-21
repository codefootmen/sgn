package model;

import lombok.Data;

@Data
public class Student extends Person {
    private Long idStudent;
    private Activity activity;

}
