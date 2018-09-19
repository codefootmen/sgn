package model;

import lombok.Data;

@Data
public class Campus {
    private Long id;
    private String name;
    private String street;
    private Long number;
    private String city;
    private String state;
    private String telephone;
    private String zip;
    private Institution institution;
}
