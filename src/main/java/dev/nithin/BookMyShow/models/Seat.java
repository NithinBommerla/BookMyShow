package dev.nithin.BookMyShow.models;

import dev.nithin.BookMyShow.models.constants.SeatStatus;
import dev.nithin.BookMyShow.models.constants.SeatType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel{
    private int row;
    private int column;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;



}
