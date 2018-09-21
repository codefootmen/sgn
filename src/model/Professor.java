package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class Professor extends Person{
    private Long idProfessor;
    private HonorificsEnum honorifics;
    private StatusEnum status;

    public Professor(){};

    public Professor(String firstName, String lastName, String email, Long idProfessor, HonorificsEnum honorifics, StatusEnum status) {
        super(firstName, lastName, email);
        this.idProfessor = idProfessor;
        this.honorifics = honorifics;
        this.status = status;
    }
}
