package entity;

import javax.persistence.*;

@Entity
@Table(name = "subject", schema = "sgn", catalog = "")
@IdClass(SubjectEntityPK.class)
public class SubjectEntity {
    private long idSubject;
    private String name;
    private int quantityOfCredits;
    private long idProgram;
    private long idDepartment;
    private long idCampus;
    private long idInstitute;

    @Id
    @Column(name = "id_subject")
    public long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(long idSubject) {
        this.idSubject = idSubject;
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
    @Column(name = "quantity_of_credits")
    public int getQuantityOfCredits() {
        return quantityOfCredits;
    }

    public void setQuantityOfCredits(int quantityOfCredits) {
        this.quantityOfCredits = quantityOfCredits;
    }

    @Id
    @Column(name = "id_program")
    public long getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(long idProgram) {
        this.idProgram = idProgram;
    }

    @Id
    @Column(name = "id_department")
    public long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
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

        SubjectEntity that = (SubjectEntity) o;

        if (idSubject != that.idSubject) return false;
        if (quantityOfCredits != that.quantityOfCredits) return false;
        if (idProgram != that.idProgram) return false;
        if (idDepartment != that.idDepartment) return false;
        if (idCampus != that.idCampus) return false;
        if (idInstitute != that.idInstitute) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSubject ^ (idSubject >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + quantityOfCredits;
        result = 31 * result + (int) (idProgram ^ (idProgram >>> 32));
        result = 31 * result + (int) (idDepartment ^ (idDepartment >>> 32));
        result = 31 * result + (int) (idCampus ^ (idCampus >>> 32));
        result = 31 * result + (int) (idInstitute ^ (idInstitute >>> 32));
        return result;
    }
}
