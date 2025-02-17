package dev.nithin.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // Tells JPA that all the attributes present here should be present in all the child classes (Tables)
@EntityListeners(AuditingEntityListener.class) // Listens to all entity changes - i.e. Any change in table for an entity whether creation or updation of existing rows
public abstract class BaseModel { // Abstract because we need no object of this class alone, Not an interface because attributes are not static and final.
    @Id // tels JPA that this field is PK (Primary Key)
    @GeneratedValue(strategy = GenerationType.AUTO) // Autogenerate the value for ID
    private int id;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP) // Tells JPA that this field is going to store timestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP) // Tells JPA that this field is going to store timestamp
    private LocalDateTime updatedAt;
//    private String createdBy;
//    private String updatedBy;
}
