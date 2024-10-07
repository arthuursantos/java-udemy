package application;

import db.DB;
import db.DbIntegrityException;
import src.db.DbException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {

            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "delete from city "
                    +"where Name = ?"
            );

            st.setString(1, "Ubatuba");

            int rowsAffected = st.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
