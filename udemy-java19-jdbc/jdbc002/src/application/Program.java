package application;

import db.DB;
import src.db.DbException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "insert into city (Name, CountryCode, District, Population) values"
                            +"(?, ?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS); // retorna as chaves geradas pelo auto-increment

            st.setString(1, "Ubatuba");
            st.setString(2, "BRA");
            st.setString(3, "São Paulo");
            st.setInt(4, 92981);

            int rowsAffected = st.executeUpdate(); // retorna a qtd de linhas alteradas/criadas

            if (rowsAffected > 0) {
                System.out.println("Done! Rows affected: "+rowsAffected);
                ResultSet rs = st.getGeneratedKeys(); // resultset com uma unica coluna (ids gerados)
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("ID: "+id);
                }
            } else {
                System.out.println("No rows affected");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
