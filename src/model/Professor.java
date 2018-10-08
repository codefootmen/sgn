package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Professor extends Person {
    private Long idProfessor;
    private StatusEnum status;
    private HonorificsEnum honorifics;

    public Professor setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Professor setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Professor setEmail(String email) {
        this.email = email;
        return this;
    }

    public Professor setStatus(String status) {
        this.status = StatusEnum.valueOf(status.toUpperCase());
        return this;
    }

    public Professor setHonorifics(String honorifics) {
        this.honorifics = HonorificsEnum.valueOf(honorifics.toUpperCase());
        return this;
    }


}
