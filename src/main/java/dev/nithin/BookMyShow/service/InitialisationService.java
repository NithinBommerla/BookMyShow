package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.model.*;
import dev.nithin.BookMyShow.model.constants.SeatStatus;
import dev.nithin.BookMyShow.model.constants.SeatType;
import dev.nithin.BookMyShow.model.constants.ShowStatus;
import dev.nithin.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitialisationService {
    @Autowired
    private CityService cityService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ShowService showService;
    @Autowired
    private TheatreRepository theatreRepository;

    public void initialise() {
        // create seats
        List<Seat> seats = new ArrayList<>();
        for(int i = 0, s = 1; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                Seat seat = new Seat();
                seat.setSeatNumber("Seat-" + (s++));
                seat.setRowNo(i);
                seat.setColumnNo(j);
                seat.setSeatStatus(SeatStatus.AVAILABLE);
                seat.setSeatType(SeatType.GOLD);
                seat = seatService.createSeat(seat);
                seats.add(seat);
            }
        }

        // create Auditorium
        Auditorium auditorium = new Auditorium();
        auditorium.setName("AUDI-01");
        auditorium.setCapacity(100);
        auditorium.setSeats(seats);
        auditorium = auditoriumService.createAuditorium(auditorium);
//        List<Auditorium> auditoriums = new ArrayList<>();
//        for(int i = 1; i <= 4; i++) {
//            Auditorium auditorium = new Auditorium();
//            auditorium.setName("AUDI-0"+i);
//            auditorium.setCapacity(100);
//            auditorium.setSeats(seats);
//            auditorium = auditoriumService.createAuditorium(auditorium);
//        }

        // create Theatre
        Theatre theatre = new Theatre();
        theatre.setName("PVR INOX");
        theatre.setAddress("Road No 36, Jubliee Hills, Hyderabad, 500011");
        theatre = theatreService.createTheatre(theatre);

        // create city
        City city = new City();
        city.setName("Hyderabad");
        city.setTheatres(List.of(theatre));
        city = cityService.createCity(city);

        // create Movie
        Movie movie = new Movie();
        movie.setName("Kingdom");
        movie.setLanguage("Telugu");
        movie = movieService.addMovie(movie);

        // create Show
        Show show = new Show();
        show.setMovie(movie);
        show.setAuditorium(auditorium);
        show.setLanguage("Telugu");
        show.setShowStatus(ShowStatus.SCHEDULED);
        show.setStartTime(LocalDateTime.of(2025, 5, 30, 10, 0));
        show.setEndTime(LocalDateTime.of(2025, 5, 30, 13, 0));
        show = showService.createShow(show);
    }


}
