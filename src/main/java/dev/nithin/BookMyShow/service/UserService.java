package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.AuditoriumNotFoundException;
import dev.nithin.BookMyShow.exception.UserNotFoundException;
import dev.nithin.BookMyShow.model.Auditorium;
import dev.nithin.BookMyShow.model.User;
import dev.nithin.BookMyShow.repository.AuditoriumRepository;
import dev.nithin.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(("User not found with id: "+id))
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
