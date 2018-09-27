package model;

import lombok.Data;

@Data
public class Subject {
    private Long idSubject;
    private String name;
    private Integer quantityOfCredits;
    private Program program;
    private RoomType roomType;
    private Department department;
    private Campus campus;
    private Institution institution;
}
