package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.ShowSeatNotFoundException;
import dev.nithin.BookMyShow.model.ShowSeat;
import dev.nithin.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat createShowSeat (ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    public ShowSeat getShowSeatById(int id) {
        return showSeatRepository.findById(id).orElseThrow(
                () -> new ShowSeatNotFoundException("ShowSeat not found with id: "+id)
        );
    }

    public ShowSeat getShowSeatByMovieId(int movie_id) {
        return showSeatRepository.findById(movie_id).orElseThrow(
                () -> new ShowSeatNotFoundException("ShowSeat not found with id: "+movie_id)
        );
    }

    public List<ShowSeat> getAllShowSeats() {
        return showSeatRepository.findAll();
    }

    public void deleteShowSeatById(int id) {
        showSeatRepository.deleteById(id);
    }
}
