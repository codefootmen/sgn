package model;

import lombok.Data;

@Data
public class Subject {
    private Long id;
    private String name;
    private Integer quantityOfCredits;
    private Program program;
    private RoomType roomType;
}
