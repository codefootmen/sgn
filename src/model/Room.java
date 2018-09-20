package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Room {
    private Long id;
    private Integer number;
    private Integer quantityOfSeats;
    private Building building;
    private RoomType roomType;

}
