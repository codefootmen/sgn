package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Program {
    private Long idProgram;
    private String name;
    private Department department;
    private Campus campus;
    private Institution institution;
    private AcademicLevelEnum academicLevel;
}
