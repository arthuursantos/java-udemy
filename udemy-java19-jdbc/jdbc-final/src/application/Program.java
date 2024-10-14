package application;

import model.dao.CityDao;
import model.dao.CountryDao;
import model.dao.DaoFactory;
import model.entities.City;
import model.entities.Country;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // CITYDAO IMPL TESTS

//        System.out.println("\n[CITYDAO TESTS] findByID");
//        CityDao cityDao = DaoFactory.createCityDao();
//        City obj = cityDao.findById(358);
//        System.out.println(obj);
//
//        System.out.println("\n[CITYDAO TESTS] findByCountry");
//        CityDao cityDao = DaoFactory.createCityDao();
//        List<City> cities = cityDao.findByCountry(new Country("BRA", "Brasil", "South AMerica"));
//        cities.forEach(System.out::println);
//
//        System.out.println("\n[CITYDAO TESTS] findAll");
//        CityDao cityDao = DaoFactory.createCityDao();
//        cities = cityDao.findAll();
//        cities.forEach(System.out::println);
//
//        System.out.println("\n[CITYDAO TESTS] insert");
//        CityDao cityDao = DaoFactory.createCityDao();
//        cityDao.insert(new City(1, "Ubatuba", "São Paulo", 91824, new Country("BRA", "Brasil", "South America")));
//
//        System.out.println("\n[CITYDAO TESTS] update");
//        CityDao cityDao = DaoFactory.createCityDao();
//        City city = cityDao.findById(345);
//        city.setPopulation(102439);
//        cityDao.update(city);
//
//        System.out.println("\n[CITYDAO TESTS] deleteByID");
//        System.out.print("ID: ");
//        CityDao cityDao = DaoFactory.createCityDao();
//        cityDao.deleteById(sc.nextInt());

        //COUNTRYDAO IMPL TESTS

//        System.out.println("\n[COUNTRYDAO TESTS] insert");
//        CountryDao countryDao = DaoFactory.createCountryDao();
//        countryDao.insert(new Country("TST", "Tests", "Asia"));

//        System.out.println("\n[COUNTRYDAO TESTS] update");
//        CountryDao countryDao = DaoFactory.createCountryDao();
//        Country country = countryDao.findById("ISR");
//        country.setContinent("Europe");
//        countryDao.update(country);

//        System.out.println("\n[COUNTRYDAO TESTS] deleteByID");
//        CountryDao countryDao = DaoFactory.createCountryDao();
//        System.out.print("ID for delete: ");
//        countryDao.deleteById(sc.nextLine());
//
//        System.out.println("\n[COUNTRYDAO TESTS] findByID");
//        CountryDao countryDao = DaoFactory.createCountryDao();
//        System.out.println(countryDao.findById("BRA"));
//
//        System.out.println("\n[COUNTRYDAO TESTS] findAll");
//        CountryDao countryDao = DaoFactory.createCountryDao();
//        List<Country> countries = countryDao.findAll();
//        countries.forEach(System.out::println);

        sc.close();

    }
}
