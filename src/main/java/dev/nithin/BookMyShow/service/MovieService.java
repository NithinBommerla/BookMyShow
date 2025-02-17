package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.MovieNotFoundException;
import dev.nithin.BookMyShow.model.Movie;
import dev.nithin.BookMyShow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowService showService; // To update changes in bms_show as well (Especially in case of deletion)

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new MovieNotFoundException("Movie not found with id: "+id)
        );
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void deleteMovieById(int id) {
        // Delegate the deletion of dependent shows to ShowService
        showService.deleteShowsByMovieId(id);

        movieRepository.deleteById(id);
    }
}
