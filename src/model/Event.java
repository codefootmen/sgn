package model;

import lombok.Data;

@Data
public class Event {
    private Long id;
    private String day;
    private String name;
    private Period period;
    private Professor professor;
    private Room room;
}
