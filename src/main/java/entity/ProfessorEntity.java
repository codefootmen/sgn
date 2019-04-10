package entity;

import javax.persistence.*;

@Entity
@Table(name = "professor", schema = "sgn", catalog = "")
public class ProfessorEntity {
    private long idProfessor;
    private String firstName;
    private String lastName;
    private String email;
    private Object status;
    private Object honorifics;

    @Id
    @Column(name = "id_professor")
    public long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(long idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "status")
    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Basic
    @Column(name = "honorifics")
    public Object getHonorifics() {
        return honorifics;
    }

    public void setHonorifics(Object honorifics) {
        this.honorifics = honorifics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfessorEntity that = (ProfessorEntity) o;

        if (idProfessor != that.idProfessor) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (honorifics != null ? !honorifics.equals(that.honorifics) : that.honorifics != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idProfessor ^ (idProfessor >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (honorifics != null ? honorifics.hashCode() : 0);
        return result;
    }
}
