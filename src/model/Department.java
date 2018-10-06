package model;

import lombok.Data;

@Data
public class Department {
    private Long idDepartment;
    private String field;
    private String description;
    private Campus campus;
    private Institution institution;
    private Professor professor;
}
