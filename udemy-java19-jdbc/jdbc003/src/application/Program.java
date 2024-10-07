package application;

import db.DB;
import src.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(
                    "update employees "
                    +"set email = ? "
                    +"where employeeNumber = ?"
            );

            ps.setString(1, "arthursantos@classicmodels.com");
            ps.setInt(2, 1707);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }

    }
}
