package dev.nithin.BookMyShow.controller;

import dev.nithin.BookMyShow.repository.TicketRepository;
import dev.nithin.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello Rest API World");
    }
}
