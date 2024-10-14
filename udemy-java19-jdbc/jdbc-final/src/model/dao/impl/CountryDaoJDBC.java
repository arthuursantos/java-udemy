package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.CountryDao;
import model.entities.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoJDBC implements CountryDao {

    private Connection conn;

    public CountryDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Country obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into country values (?,?,?)");
            ps.setString(1, obj.getCode());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getContinent());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Country inserted successfully!");
            } else {
                throw new DbException("Country insertion failed!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Country obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update country set code = ?, name = ?, continent = ? where code = ?");
            ps.setString(1, obj.getCode());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getContinent());
            ps.setString(4, obj.getCode());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Country updated successfully! ID: " + obj.getCode());
            } else {
                throw new DbException("Country update failed!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(String code) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from country where code = ?");
            ps.setString(1, code);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Country deleted successfully!");
            } else {
                throw new DbException("Country deletion failed!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Country findById(String code) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from country where code = ?");
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Country(rs.getString("code"), rs.getString("name"), rs.getString("continent"));
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Country> findAll() {
        Statement st = null;
        ResultSet rs = null;
        List<Country> countries = new ArrayList<Country>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from country");
            while (rs.next()) {
                countries.add(new Country(rs.getString("code"), rs.getString("name"), rs.getString("continent")));
            }
            return countries;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
