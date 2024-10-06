package app.dtos;

import app.entities.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("rooms")
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

    public HotelDTO(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}// end class
