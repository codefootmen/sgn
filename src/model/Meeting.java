package model;

import lombok.Data;

@Data
public class Meeting {
    private Long id;
    private String day;
    private String time;
    private String agenda;
    private String minutes;
    private Department departament;
}
