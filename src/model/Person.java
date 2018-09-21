package model;

import lombok.Data;

@Data
public abstract class Person {

    private String firstName;
    private String lastName;
    private String email;

    public Person(){}

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
