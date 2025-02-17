package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.AuditoriumNotFoundException;
import dev.nithin.BookMyShow.exception.SeatNotFoundException;
import dev.nithin.BookMyShow.model.Auditorium;
import dev.nithin.BookMyShow.model.Seat;
import dev.nithin.BookMyShow.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat getSeatById(int id) {
        return seatRepository.findById(id).orElseThrow(
                () -> new SeatNotFoundException("Seat not found with id: "+id)
        );
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public void deleteSeatById(int id) {
        seatRepository.deleteById(id);
    }
}
