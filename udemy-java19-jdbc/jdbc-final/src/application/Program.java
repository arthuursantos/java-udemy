package application;

import model.dao.CityDao;
import model.dao.DaoFactory;
import model.entities.City;
import model.entities.Country;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Country brasil = new Country("BRA", "Brasil","South America");
        City ubatuba = new City(1, "Ubatuba", "São Paulo", 91824, brasil);

//        System.out.println("\n[TEST] findByID");
//        CityDao cityDao = DaoFactory.createCityDao();
//        City obj = cityDao.findById(358);
//        System.out.println(obj);
//
//        System.out.println("\n[TEST] findByCountry");
//        List<City> cities = cityDao.findByCountry(brasil);
//        cities.forEach(System.out::println);
//
//        System.out.println("\n[TEST] findAll");
//        cities = cityDao.findAll();
//        cities.forEach(System.out::println);

//        System.out.println("\n[TEST] insert");
//        CityDao cityDao = DaoFactory.createCityDao();
//        cityDao.insert(ubatuba);

//        System.out.println("\n[TEST] update");
//        CityDao cityDao = DaoFactory.createCityDao();
//        city = cityDao.findById(345);
//        city.setPopulation(102439);
//        cityDao.update(city);

        System.out.println("\n[TEST] deleteByID");
        System.out.print("ID: ");
        CityDao cityDao = DaoFactory.createCityDao();
        cityDao.deleteById(sc.nextInt());

        sc.close();

    }
}
