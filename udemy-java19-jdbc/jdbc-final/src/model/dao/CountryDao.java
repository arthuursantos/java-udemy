package model.dao;

import model.entities.Country;

import java.util.List;

public interface CountryDao {
    void insert(Country obj);
    void update(Country obj);
    void deleteById(String code);
    Country findById(String code);
    List<Country> findAll();
}
