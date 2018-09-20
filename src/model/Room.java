package model;

import lombok.Data;

@Data
public class Room {
    private Long id;
    private Integer number;
    private Integer quantityOfSeats;
    private Building building;
    private RoomType roomType;

}
