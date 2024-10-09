package model.dao;

import model.entities.Country;

import java.util.List;

public interface CountryDao {
    void insert(Country obj);
    void update(Country obj);
    void deleteById(Integer id);
    Country findById(Integer id);
    List<Country> findAll();
}
