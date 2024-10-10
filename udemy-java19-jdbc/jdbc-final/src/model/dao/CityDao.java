package model.dao;

import model.entities.City;
import model.entities.Country;

import java.util.List;

public interface CityDao {
    void insert(City obj);
    void update(City obj);
    void deleteById(Integer id);
    City findById(Integer id);
    List<City> findAll();
    List<City> findByCountry(Country country);
}