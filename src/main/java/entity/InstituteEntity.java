package entity;

import javax.persistence.*;

@Entity
@Table(name = "institute", schema = "sgn", catalog = "")
public class InstituteEntity {
    private long idInstitute;
    private String name;
    private String site;

    @Id
    @Column(name = "id_institute")
    public long getIdInstitute() {
        return idInstitute;
    }

    public void setIdInstitute(long idInstitute) {
        this.idInstitute = idInstitute;
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
    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstituteEntity that = (InstituteEntity) o;

        if (idInstitute != that.idInstitute) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (site != null ? !site.equals(that.site) : that.site != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idInstitute ^ (idInstitute >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        return result;
    }
}
