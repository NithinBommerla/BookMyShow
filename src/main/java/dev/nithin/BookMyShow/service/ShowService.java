package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.model.Ticket;
import dev.nithin.BookMyShow.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowService {
    @Autowired
    private ShowRepository showRepository;

}
