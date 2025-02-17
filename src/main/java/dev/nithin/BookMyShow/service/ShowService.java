package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.ShowNotFoundException;
import dev.nithin.BookMyShow.model.Seat;
import dev.nithin.BookMyShow.model.Show;
import dev.nithin.BookMyShow.model.ShowSeat;
import dev.nithin.BookMyShow.model.constants.ShowSeatStatus;
import dev.nithin.BookMyShow.repository.ShowRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatService showSeatService;

    public Show createShow(Show show) {
        // create the showSeats for the show
        List<ShowSeat> showSeats = new ArrayList<>();
        show = showRepository.save(show);

        List<Seat> seats = show.getAuditorium().getSeats();
        for (Seat seat : seats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setPrice(100);
            showSeat.setShow(show);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeat = showSeatService.createShowSeat(showSeat);
            showSeats.add(showSeat);
        }
        show.setShowSeats(showSeats);
        return showRepository.save(show);
    }

    public Show getShowById(int id) {
        return showRepository.findById(id).orElseThrow(
                () -> new ShowNotFoundException("Show not found with id: "+id)
        );
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public void deleteShowById(int id) {
        showRepository.deleteById(id);
    }

    @Transactional
    public void deleteShowsByMovieId(int movieId) {
        // Find all shows associated with the given movie ID
        List<Show> shows = showSeatService.findByMovieId(movieId);

        // Delete all show_seat records for each show
        for (Show show : shows) {
            showSeatService.deleteByShowId(show.getId());
        }

        // Delete the shows themselves
        showRepository.deleteByMovieId(movieId);
    }

}
