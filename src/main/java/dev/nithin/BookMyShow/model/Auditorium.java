package dev.nithin.BookMyShow.model;

import dev.nithin.BookMyShow.model.constants.AuditoriumFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show> shows;
    @ElementCollection // creates a relationship between Auditorium and enum table
    @Enumerated(EnumType.STRING) // creates a table for values present in enum
    private List<AuditoriumFeatures> auditoriumFeatures;
}
