package model;

import lombok.Data;

@Data
public class Request {
    private Long idRequest;
    private String motive;
    private String description;
    private PriorityEnum priority;
    private Room room;
}
