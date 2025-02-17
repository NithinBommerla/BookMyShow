package dev.nithin.BookMyShow.repository;

import dev.nithin.BookMyShow.model.ShowSeat;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM ShowSeat ss WHERE ss.show.id = :showId")
    void deleteByShowId(@Param("showId") int showId);
}
