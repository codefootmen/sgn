package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Subject {
    private Long idSubject;
    private String name;
    private Integer quantityOfCredits;
    private RoomType roomType;
    private Long idRoomType;
    private Program program;
    private Long idProgram;
    private Department department;
    private Long idDepartment;
    private Campus campus;
    private Long idCampus;
    private Institution institution;
    private Long idInstitution;
}
