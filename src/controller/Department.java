package controller;

public class Department {
    private Long id;
    private String field;
    private String description;
    private Professor head;

    public Department(Long id, String field, String description, Professor head) {
        this.id = id;
        this.field = field;
        this.description = description;
        this.head = head;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Professor getHead() {
        return head;
    }

    public void setHead(Professor head) {
        this.head = head;
    }
}
