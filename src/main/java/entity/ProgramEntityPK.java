package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProgramEntityPK implements Serializable {
    private long idProgram;
    private long idDepartment;
    private long idCampus;
    private long idInstitute;

    @Column(name = "id_program")
    @Id
    public long getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(long idProgram) {
        this.idProgram = idProgram;
    }

    @Column(name = "id_department")
    @Id
    public long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Column(name = "id_campus")
    @Id
    public long getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(long idCampus) {
        this.idCampus = idCampus;
    }

    @Column(name = "id_institute")
    @Id
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

        ProgramEntityPK that = (ProgramEntityPK) o;

        if (idProgram != that.idProgram) return false;
        if (idDepartment != that.idDepartment) return false;
        if (idCampus != that.idCampus) return false;
        if (idInstitute != that.idInstitute) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idProgram ^ (idProgram >>> 32));
        result = 31 * result + (int) (idDepartment ^ (idDepartment >>> 32));
        result = 31 * result + (int) (idCampus ^ (idCampus >>> 32));
        result = 31 * result + (int) (idInstitute ^ (idInstitute >>> 32));
        return result;
    }
}
