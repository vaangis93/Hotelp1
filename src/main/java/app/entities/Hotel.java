package app.entities;

import app.dtos.HotelDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "hotels")
// TODO how to link ROOMS and how to make constructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "rooms")

    @ToString.Exclude
    @OneToMany(mappedBy = "hotelId", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @ElementCollection
    private List<Room> rooms  = new ArrayList<>();

    //
    public Hotel(HotelDTO hotelDTO) {
        this.id = hotelDTO.getId();
        this.name = hotelDTO.getName();
        this.address = hotelDTO.getAddress();
        this.rooms = hotelDTO.getRooms()
                .stream()
                .map(roomDTO -> {
                    if (roomDTO == null) {
                        return null;
                    } else {
                        return new Room(roomDTO);
                    }

                })
                .collect(Collectors.toList());

    }

    public Hotel(int id) {
        this.id = id;
    }

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Hotel(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}// end class
