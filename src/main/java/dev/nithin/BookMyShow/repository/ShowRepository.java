package dev.nithin.BookMyShow.repository;

import dev.nithin.BookMyShow.model.Show;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM BMS_Show s WHERE s.movie.id = :movieId")
    void deleteByMovieId(@Param("movieId") int movieId);
}
