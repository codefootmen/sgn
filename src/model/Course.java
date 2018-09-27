package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Course {
    private Long idCourse;
    private Boolean semester;
    private Integer year;
    private Subject subject;
    private Program program;
    private Department department;
    private Campus campus;
    private Institution institution;
    private Period period;
    private Professor professor;
    private Room room;
}
