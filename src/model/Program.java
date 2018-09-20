package model;

import lombok.Data;

@Data
public class Program {
    private Long id;
    private String name;
    private Department department;
}
