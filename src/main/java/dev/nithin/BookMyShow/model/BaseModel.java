package dev.nithin.BookMyShow.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // Tells JPA that all the attributes present here should be present in all the child classes (Tables)
public abstract class BaseModel { // Abstract because we need no object of this class alone, Not an interface because attributes are not static and final.
    @Id // tels JPA that this field is PK (Primary Key)
    @GeneratedValue(strategy = GenerationType.AUTO) // Autogenerate the value for ID
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private String createdBy;
//    private String updatedBy;
}
