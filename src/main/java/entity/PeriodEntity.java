package entity;

import javax.persistence.*;

@Entity
@Table(name = "period", schema = "sgn", catalog = "")
public class PeriodEntity {
    private long idPeriod;
    private String start;
    private String end;
    private String dayOfTheWeek;

    @Id
    @Column(name = "id_period")
    public long getIdPeriod() {
        return idPeriod;
    }

    public void setIdPeriod(long idPeriod) {
        this.idPeriod = idPeriod;
    }

    @Basic
    @Column(name = "start")
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Basic
    @Column(name = "day_of_the_week")
    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeriodEntity that = (PeriodEntity) o;

        if (idPeriod != that.idPeriod) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        if (dayOfTheWeek != null ? !dayOfTheWeek.equals(that.dayOfTheWeek) : that.dayOfTheWeek != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPeriod ^ (idPeriod >>> 32));
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (dayOfTheWeek != null ? dayOfTheWeek.hashCode() : 0);
        return result;
    }
}
