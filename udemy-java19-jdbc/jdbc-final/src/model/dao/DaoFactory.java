package model.dao;

import db.DB;
import model.dao.impl.CityDaoJDBC;
import model.dao.impl.CountryDaoJDBC;

public class DaoFactory {

    public static CityDao createCityDao() {
        return new CityDaoJDBC(DB.getConnection());
    }

    public static CountryDao createCountryDao() {
        return new CountryDaoJDBC(DB.getConnection());
    }

}
