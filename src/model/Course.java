package model;

import lombok.Data;

@Data
public class Course {
    private Long id;
    private Boolean semester;
    private Integer year;
    private Subject subject;
    private Professor professor;
    private Room room;
}
