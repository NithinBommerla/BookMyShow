package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.AuditoriumNotFoundException;
import dev.nithin.BookMyShow.model.Auditorium;
import dev.nithin.BookMyShow.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public Auditorium createAuditorium (Auditorium auditorium) {
        return auditoriumRepository.save(auditorium);
    }

    public Auditorium getAuditoriumById(int id) {
        return auditoriumRepository.findById(id).orElseThrow(
                () -> new AuditoriumNotFoundException("Auditorium not found with id: "+id)
        );
    }

    public List<Auditorium> getAllAuditoriums() {
        return auditoriumRepository.findAll();
    }

    public void deleteAuditoriumById(int id) {
        auditoriumRepository.deleteById(id);
    }
}
