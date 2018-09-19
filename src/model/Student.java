package model;

import lombok.Data;

@Data
public class Student extends Person{
    private String enrollment;
    private Activity activity;
}
