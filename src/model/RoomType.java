package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoomType {
    private Long idRoomType;
    private String name;
    private String description;

}
