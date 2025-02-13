package dev.nithin.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.xml.sax.Locator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private LocalDateTime paymentDate;
    private double amount;
    private String paymentReference;
}
