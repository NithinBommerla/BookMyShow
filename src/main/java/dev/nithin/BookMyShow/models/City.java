package dev.nithin.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity // tells JPA to create a table for this class
public class City extends BaseModel{
    private String name;
    @OneToMany // Sets the relationship cardinality b/w City and Theatre
    private List<Theatre> theatres;

}

