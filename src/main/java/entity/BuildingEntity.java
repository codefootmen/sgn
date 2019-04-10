package entity;

import javax.persistence.*;

@Entity
@Table(name = "building", schema = "sgn", catalog = "")
public class BuildingEntity {
    private long idBuilding;
    private String name;
    private int quantityOfBathrooms;
    private boolean elevator;
    private boolean accessibility;

    @Id
    @Column(name = "id_building")
    public long getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(long idBuilding) {
        this.idBuilding = idBuilding;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "quantity_of_bathrooms")
    public int getQuantityOfBathrooms() {
        return quantityOfBathrooms;
    }

    public void setQuantityOfBathrooms(int quantityOfBathrooms) {
        this.quantityOfBathrooms = quantityOfBathrooms;
    }

    @Basic
    @Column(name = "elevator")
    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    @Basic
    @Column(name = "accessibility")
    public boolean isAccessibility() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuildingEntity that = (BuildingEntity) o;

        if (idBuilding != that.idBuilding) return false;
        if (quantityOfBathrooms != that.quantityOfBathrooms) return false;
        if (elevator != that.elevator) return false;
        if (accessibility != that.accessibility) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idBuilding ^ (idBuilding >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + quantityOfBathrooms;
        result = 31 * result + (elevator ? 1 : 0);
        result = 31 * result + (accessibility ? 1 : 0);
        return result;
    }
}
