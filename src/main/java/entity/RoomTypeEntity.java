package entity;

import javax.persistence.*;

@Entity
@Table(name = "room_type", schema = "sgn", catalog = "")
public class RoomTypeEntity {
    private long idRoomType;
    private String name;
    private String description;

    @Id
    @Column(name = "id_room_type")
    public long getIdRoomType() {
        return idRoomType;
    }

    public void setIdRoomType(long idRoomType) {
        this.idRoomType = idRoomType;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomTypeEntity that = (RoomTypeEntity) o;

        if (idRoomType != that.idRoomType) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRoomType ^ (idRoomType >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
