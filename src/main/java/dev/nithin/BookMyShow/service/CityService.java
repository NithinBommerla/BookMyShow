package dev.nithin.BookMyShow.service;

import dev.nithin.BookMyShow.exception.CityNotFoundException;
import dev.nithin.BookMyShow.model.City;
import dev.nithin.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City createCity (City city) {
        return cityRepository.save(city);
    }

    public City getCityById(int id) {
        return cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City not found with id: "+id)
        );
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public void deleteCityById(int id) {
        cityRepository.deleteById(id);
    }
}

