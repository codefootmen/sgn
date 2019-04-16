package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.MappedSuperclass;

@Data
@Accessors(chain = true)
@MappedSuperclass
public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected String email;
}
