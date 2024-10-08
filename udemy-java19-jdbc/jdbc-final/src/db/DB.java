package db;

import src.db.DbException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadproperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }
    // metodo que instancia uma conexao sql usando as propriedades de src.db.properties

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
    // metodo que finaliza uma conexao sql

    public static Properties loadproperties() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\java-udemy\\udemy-java19-jdbc\\jdbc005\\db.properties"))) {
            Properties props = new Properties();
            props.load(br);
            return props;
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

}
