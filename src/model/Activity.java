package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Activity {
    private Long id;
    private String name;
    private ActivityTypeEnum activity;
    private String area;
    private Professor professor;
}
