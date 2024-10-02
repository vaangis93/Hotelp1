package app.dtos;

import app.entities.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelDTO {


    private int id;
    private String name;
    private String address;
    private List<RoomDTO> rooms = new ArrayList<>();

    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.address = hotel.getAddress();
        this.rooms = hotel.getRooms()
                .stream()
                .map(rooms -> {
                    if (rooms == null) {
                        return null;
                    } else {
                        return new RoomDTO(rooms);
                    }
                })
                .collect(Collectors.toList());
    }



}// end class
