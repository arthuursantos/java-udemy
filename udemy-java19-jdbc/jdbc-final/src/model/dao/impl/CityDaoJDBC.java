package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.CityDao;
import model.entities.City;
import model.entities.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityDaoJDBC implements CityDao {

    private Connection conn;

    public CityDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(City obj) {

    }

    @Override
    public void update(City obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public City findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "select city.*, country.name as CountryName, country.continent as CountryContinent"
                            + " from city inner join country on city.CountryCode = country.Code"
                            + " where city.id = ?;"
            );
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Country country = instanciateCountry(rs);
                return instanciateCity(rs, country);
            }
            return null;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    private City instanciateCity(ResultSet rs, Country country) throws SQLException {
        City city = new City();
        city.setID(rs.getInt("ID"));
        city.setName(rs.getString("Name"));
        city.setCountry(country);
        city.setDistrict(rs.getString("District"));
        city.setPopulation(rs.getInt("Population"));
        return city;
    }

    private Country instanciateCountry(ResultSet rs) throws SQLException {
        Country country = new Country();
        country.setCode(rs.getString("CountryCode"));
        country.setName(rs.getString("CountryName"));
        country.setContinent(rs.getString("CountryContinent"));
        return country;
    }

    @Override
    public List<City> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<City> cities = new ArrayList<>();
        Map<String, Country> countries = new HashMap<>();
        try {
            st = conn.prepareStatement(
                    "select city.*, country.Name as CountryName, country.Continent as CountryContinent "
                    + "from city inner join country on city.CountryCode = country.Code "
                    + "order by city.Name;"
            );
            rs = st.executeQuery();
            while (rs.next()) {
                Country country = countries.get(rs.getString("CountryCode"));
                if (country == null) {
                    country = instanciateCountry(rs);
                    countries.put(rs.getString("CountryCode"), country);
                }
                cities.add(instanciateCity(rs, country));
            }
            return cities;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<City> findByCountry(Country country) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement(
                    "select city.*, country.Name as CountryName, country.Continent as CountryContinent "
                    + "from city inner join country on city.CountryCode = country.Code "
                    + "where city.CountryCode = ? "
                    + "order by city.Name;"
            );
            st.setString(1, country.getCode());
            rs = st.executeQuery();

            List<City> cities = new ArrayList<>();
            Map<String, Country> countries = new HashMap<>();

            while (rs.next()) {
                Country mapCountry = countries.get(rs.getString("CountryCode"));
                if (mapCountry == null) {
                    mapCountry = instanciateCountry(rs);
                    countries.put(rs.getString("CountryCode"), mapCountry);
                }
                cities.add(instanciateCity(rs, mapCountry));
            }

            return cities;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

}