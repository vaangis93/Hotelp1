package app.entities;

import app.dtos.RoomDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne
    // for naming the column in the table
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotelId;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "price", nullable = false)
    private int price;


    // making constructor for RoomDTO

    public Room(RoomDTO roomDTO) {
        this.id = roomDTO.getId();
        this.hotelId = roomDTO.getHotelId();
        this.number = roomDTO.getNumber();
        this.price = roomDTO.getPrice();
    }

    public Room(Hotel hotelId, int number, int price) {
        this.hotelId = hotelId;
        this.number = number;
        this.price = price;
    }

    // making construtor for hotelId getting the id from the hotel
    public Room(Hotel hotelId) {
        hotelId.getId();
        this.hotelId = hotelId;
    }
}// end class
