package com.mgmetehan.sisterslabildemo.controller;

import com.mgmetehan.sisterslabildemo.dto.request.CityRequestDto;
import com.mgmetehan.sisterslabildemo.dto.response.CityResponseDto;
import com.mgmetehan.sisterslabildemo.model.City;
import com.mgmetehan.sisterslabildemo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public CityResponseDto createCity(@RequestBody CityRequestDto newCity){
        return cityService.createCity(newCity);
    }

    @GetMapping
    public List<City> getCities(@RequestParam(required = false) String name){
        return cityService.getCities(name);
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id){
        return cityService.getCity(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable Long id){
        return cityService.deleteCity(id);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id,@RequestBody City newCity){
        return cityService.updateCity(id,newCity);
    }
}
