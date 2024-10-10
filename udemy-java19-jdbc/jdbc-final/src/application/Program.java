package application;

import model.dao.CityDao;
import model.dao.DaoFactory;
import model.entities.City;
import model.entities.Country;

public class Program {
    public static void main(String[] args) {

        System.out.println("[TEST] findById");
        CityDao cityDao = DaoFactory.createCityDao();
        City obj = cityDao.findById(358);
        System.out.println(obj);

    }
}
