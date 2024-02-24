package com.mgmetehan.sisterslabildemo.repository;

import com.mgmetehan.sisterslabildemo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByName(String name);

}
