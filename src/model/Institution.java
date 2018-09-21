package model;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Institution {
    private Long idInstitution;
    private String name;
    private String logo;
    private String site;
}
