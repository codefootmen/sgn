package entity;

import javax.persistence.*;

@Entity
@Table(name = "department", schema = "sgn", catalog = "")
@IdClass(DepartmentEntityPK.class)
public class DepartmentEntity {
    private long idDepartment;
    private String field;
    private String description;
    private long idCampus;
    private long idInstitute;

    @Id
    @Column(name = "id_department")
    public long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Basic
    @Column(name = "field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "id_campus")
    public long getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(long idCampus) {
        this.idCampus = idCampus;
    }

    @Id
    @Column(name = "id_institute")
    public long getIdInstitute() {
        return idInstitute;
    }

    public void setIdInstitute(long idInstitute) {
        this.idInstitute = idInstitute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (idDepartment != that.idDepartment) return false;
        if (idCampus != that.idCampus) return false;
        if (idInstitute != that.idInstitute) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idDepartment ^ (idDepartment >>> 32));
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (idCampus ^ (idCampus >>> 32));
        result = 31 * result + (int) (idInstitute ^ (idInstitute >>> 32));
        return result;
    }
}
