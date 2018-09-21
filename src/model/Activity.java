package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Activity {
    private Long idActivity;
    private String name;
    private ActivityTypeEnum activityType;
    private String area;
    private Professor professor;
    private Department department;
    private Campus campus;
    private Institution institution;
    private Program program;

}
