package model;

import lombok.Data;

@Data
public class Subject {
    private Long idSubject;
    private String name;
    private Integer quantityOfCredits;
    private Program program;
    private RoomType roomType;
}
