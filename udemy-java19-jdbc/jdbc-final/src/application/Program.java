package application;

import model.dao.CityDao;
import model.dao.DaoFactory;
import model.entities.City;
import model.entities.Country;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        System.out.println("\n[TEST] findById");
        CityDao cityDao = DaoFactory.createCityDao();
        City obj = cityDao.findById(358);
        System.out.println(obj);

        System.out.println("\n[TEST] findByCountry");
        List<City> cities = cityDao.findByCountry(new Country("BRA", null, null));
        cities.forEach(System.out::println);

        System.out.println("\n[TEST] findAll");
        cities = cityDao.findAll();
        cities.forEach(System.out::println);

    }
}
