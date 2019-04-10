package entity;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "sgn", catalog = "")
@IdClass(CourseEntityPK.class)
public class CourseEntity {
    private long idCourse;
    private boolean semester;
    private int year;
    private long idSubject;
    private long idProgram;
    private long idDepartment;
    private long idCampus;
    private long idInstitute;

    @Id
    @Column(name = "id_course")
    public long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(long idCourse) {
        this.idCourse = idCourse;
    }

    @Basic
    @Column(name = "semester")
    public boolean isSemester() {
        return semester;
    }

    public void setSemester(boolean semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Id
    @Column(name = "id_subject")
    public long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(long idSubject) {
        this.idSubject = idSubject;
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

        CourseEntity that = (CourseEntity) o;

        if (idCourse != that.idCourse) return false;
        if (semester != that.semester) return false;
        if (year != that.year) return false;
        if (idSubject != that.idSubject) return false;
        if (idProgram != that.idProgram) return false;
        if (idDepartment != that.idDepartment) return false;
        if (idCampus != that.idCampus) return false;
        if (idInstitute != that.idInstitute) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCourse ^ (idCourse >>> 32));
        result = 31 * result + (semester ? 1 : 0);
        result = 31 * result + year;
        result = 31 * result + (int) (idSubject ^ (idSubject >>> 32));
        result = 31 * result + (int) (idProgram ^ (idProgram >>> 32));
        result = 31 * result + (int) (idDepartment ^ (idDepartment >>> 32));
        result = 31 * result + (int) (idCampus ^ (idCampus >>> 32));
        result = 31 * result + (int) (idInstitute ^ (idInstitute >>> 32));
        return result;
    }
}
