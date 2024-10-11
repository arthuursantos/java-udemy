package application;

import model.dao.CityDao;
import model.dao.DaoFactory;
import model.entities.City;
import model.entities.Country;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        Country country = new Country("BRA", "Brasil","South America");

//        System.out.println("\n[TEST] findById");
//        CityDao cityDao = DaoFactory.createCityDao();
//        City obj = cityDao.findById(358);
//        System.out.println(obj);
//
//        System.out.println("\n[TEST] findByCountry");
//        List<City> cities = cityDao.findByCountry(country);
//        cities.forEach(System.out::println);
//
//        System.out.println("\n[TEST] findAll");
//        cities = cityDao.findAll();
//        cities.forEach(System.out::println);

//        System.out.println("\n[TEST] insert");
//        CityDao cityDao = DaoFactory.createCityDao();
//        cityDao.insert(new City(1, "Ubatuba", "São Paulo", 91824, country));


    }
}
