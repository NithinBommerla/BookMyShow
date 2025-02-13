package dev.nithin.BookMyShow.models;

import dev.nithin.BookMyShow.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private double TotalCost;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    @ManyToOne
    private User user;
    private LocalDateTime bookingTime;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
