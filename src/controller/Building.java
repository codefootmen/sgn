package controller;

public class Building {
    private Long id;
    private String name;
    private Integer quantityOfBathrooms;
    private Boolean elevator;
    private Boolean accessibility;
    private Campus campus;

    public Building(Long id, String name, Integer quantityOfBathrooms, Boolean elevator, Boolean accessibility, Campus campus) {
        this.id = id;
        this.name = name;
        this.quantityOfBathrooms = quantityOfBathrooms;
        this.elevator = elevator;
        this.accessibility = accessibility;
        this.campus = campus;
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

    public Integer getQuantityOfBathrooms() {
        return quantityOfBathrooms;
    }

    public void setQuantityOfBathrooms(Integer quantityOfBathrooms) {
        this.quantityOfBathrooms = quantityOfBathrooms;
    }

    public Boolean getElevator() {
        return elevator;
    }

    public void setElevator(Boolean elevator) {
        this.elevator = elevator;
    }

    public Boolean getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Boolean accessibility) {
        this.accessibility = accessibility;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}
