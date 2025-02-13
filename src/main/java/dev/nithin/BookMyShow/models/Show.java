package dev.nithin.BookMyShow.models;

import dev.nithin.BookMyShow.models.constants.ShowStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String language;
    @ManyToOne
    private Auditorium auditorium;
    @ManyToOne
    private Movie movie;
    @OneToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.STRING)
    private ShowStatus showStatus;



}
