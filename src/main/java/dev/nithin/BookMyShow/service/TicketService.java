package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.TheatreNotFoundException;
import dev.nithin.BookMyShow.exception.TicketNotFoundException;
import dev.nithin.BookMyShow.model.Theatre;
import dev.nithin.BookMyShow.model.Ticket;
import dev.nithin.BookMyShow.repository.TheatreRepository;
import dev.nithin.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTheatre (Ticket theatre) {
        return ticketRepository.save(theatre);
    }

    public Ticket getTheatreById(int id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new TicketNotFoundException("Ticket not found with id: "+id)
        );
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void deleteTheatreById(int id) {
        ticketRepository.deleteById(id);
    }
}
