package model;

import lombok.Data;

@Data
public class Request {
    private Long id;
    private String motive;
    private String description;
    private Priority priority;
    private Room room;
}
