package dev.nithin.BookMyShow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // Tells JPA that all the attributres present here should be present in all the child classes (Tables)
public abstract class BaseModel { // abstract because we need no object of this class alone, not interface because attributes are not static and final.
    @Id // tels JPA that this field is PK (Primary Key)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO) // Autogenerate the value for ID
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private String createdBy;
//    private String updatedBy;
}
