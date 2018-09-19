package model;

import lombok.Data;

@Data
public class Period {
    private Long id;
    private String start;
    private String end;
    private String dayOfTheWeek;
}
