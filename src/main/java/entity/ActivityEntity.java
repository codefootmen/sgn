package entity;

import javax.persistence.*;

@Entity
@Table(name = "activity", schema = "sgn", catalog = "")
public class ActivityEntity {
    private long idActivity;
    private String name;
    private Object activityType;
    private String area;

    @Id
    @Column(name = "id_activity")
    public long getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(long idActivity) {
        this.idActivity = idActivity;
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
    @Column(name = "activity_type")
    public Object getActivityType() {
        return activityType;
    }

    public void setActivityType(Object activityType) {
        this.activityType = activityType;
    }

    @Basic
    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity that = (ActivityEntity) o;

        if (idActivity != that.idActivity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (activityType != null ? !activityType.equals(that.activityType) : that.activityType != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idActivity ^ (idActivity >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (activityType != null ? activityType.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        return result;
    }
}
