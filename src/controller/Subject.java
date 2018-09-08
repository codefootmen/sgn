package controller;

public class Subject {
    private Long id;
    private String name;
    private Integer quantityOfCredits;
    private Program program;

    public Subject(Long id, String name, Integer quantityOfCredits, Program program) {
        this.id = id;
        this.name = name;
        this.quantityOfCredits = quantityOfCredits;
        this.program = program;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantityOfCredits() {
        return quantityOfCredits;
    }

    public void setQuantityOfCredits(Integer quantityOfCredits) {
        this.quantityOfCredits = quantityOfCredits;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
