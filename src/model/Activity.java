package model;

import lombok.Data;

@Data
public class Activity {
    private Long id;
    private String name;
    private ActivityTypeEnum activity;
    private String area;
    private Professor professor;
}
