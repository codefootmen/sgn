package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected String email;
}
