package model;

import lombok.Data;

@Data
public class Professor extends Person{
    private Long siape;
    private HonorificsEnum honorifics;
    private StatusEnum status;
}
