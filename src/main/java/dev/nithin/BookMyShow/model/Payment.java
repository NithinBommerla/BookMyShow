package dev.nithin.BookMyShow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private LocalDateTime paymentDate;
    private double amount;
    private String paymentReference;
}
