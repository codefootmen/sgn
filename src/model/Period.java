package model;

public class Period {
    private Long id;
    private String start;
    private String end;
    private String dayOfTheWeek;

    public Period(Long id, String start, String end, String dayOfTheWeek) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
