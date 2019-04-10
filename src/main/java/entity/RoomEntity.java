package entity;

import javax.persistence.*;

@Entity
@Table(name = "room", schema = "sgn", catalog = "")
public class RoomEntity {
    private long idRoom;
    private int number;
    private int quantityOfSeats;

    @Id
    @Column(name = "id_room")
    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "quantity_of_seats")
    public int getQuantityOfSeats() {
        return quantityOfSeats;
    }

    public void setQuantityOfSeats(int quantityOfSeats) {
        this.quantityOfSeats = quantityOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (idRoom != that.idRoom) return false;
        if (number != that.number) return false;
        if (quantityOfSeats != that.quantityOfSeats) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRoom ^ (idRoom >>> 32));
        result = 31 * result + number;
        result = 31 * result + quantityOfSeats;
        return result;
    }
}
