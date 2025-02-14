package dev.nithin.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity // (name = "BMS_User") Uncomment in case we want to give a custom name to Table different from Class name
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Ticket> ticketsBooked;
    @OneToMany
    private List<Payment> payments;
}
