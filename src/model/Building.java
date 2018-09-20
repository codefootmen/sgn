package model;

import lombok.Data;

@Data
public class Building {
    private Long id;
    private String name;
    private Integer quantityOfBathrooms;
    private Boolean elevator;
    private Boolean accessibility;
    private Campus campus;

}
