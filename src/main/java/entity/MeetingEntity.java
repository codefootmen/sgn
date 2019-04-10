package entity;

import javax.persistence.*;

@Entity
@Table(name = "meeting", schema = "sgn", catalog = "")
public class MeetingEntity {
    private long idMeeting;
    private String day;
    private String time;
    private String agenda;
    private String minutes;

    @Id
    @Column(name = "id_meeting")
    public long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(long idMeeting) {
        this.idMeeting = idMeeting;
    }

    @Basic
    @Column(name = "day")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "agenda")
    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    @Basic
    @Column(name = "minutes")
    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeetingEntity that = (MeetingEntity) o;

        if (idMeeting != that.idMeeting) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (agenda != null ? !agenda.equals(that.agenda) : that.agenda != null) return false;
        if (minutes != null ? !minutes.equals(that.minutes) : that.minutes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idMeeting ^ (idMeeting >>> 32));
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (agenda != null ? agenda.hashCode() : 0);
        result = 31 * result + (minutes != null ? minutes.hashCode() : 0);
        return result;
    }
}
