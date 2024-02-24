package com.mgmetehan.sisterslabildemo.service;

import com.mgmetehan.sisterslabildemo.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mgmetehan.sisterslabildemo.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public City createCity(City newCity) {

        newCity.setCreatedDate(new Date());
        return cityRepository.save(newCity);
    }

    public List<City> getCities(String name) {
        if (Objects.isNull(name)){
            return cityRepository.findAll();
        }else {
            return cityRepository.findAllByName(name);
        }
    }

    public City getCity(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadi!!"));
    }

    public String deleteCity(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadi!!"));
        //cityRepository.delete(city);
        cityRepository.deleteById(id);
        return "Islem basarili :)";
    }

    public City updateCity(Long id, City newCity) {
        City oldCity =cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadi!!"));

        oldCity.setName(newCity.getName());
        return cityRepository.save(oldCity);
    }
}
