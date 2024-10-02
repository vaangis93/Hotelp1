package app.dtos;

import app.entities.Hotel;
import app.entities.Room;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDTO {

    private int id;
    private Hotel hotelId;
    private int number;
    private int price;

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.hotelId = room.getHotelId();
        this.number = room.getNumber();
        this.price = room.getPrice();
    }
}
