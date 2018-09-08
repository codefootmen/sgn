package controller;

public class Course {
    private Long id;
    private Boolean semester;
    private Integer year;
    private Subject subject;

    public Course(Long id, Boolean semester, Integer year, Subject subject) {
        this.id = id;
        this.semester = semester;
        this.year = year;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSemester() {
        return semester;
    }

    public void setSemester(Boolean semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
