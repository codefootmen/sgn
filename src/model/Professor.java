package model;

import lombok.Data;

@Data
public class Professor extends Person{
    private Long idProfessor;
    private HonorificsEnum honorifics;
    private StatusEnum status;
}
