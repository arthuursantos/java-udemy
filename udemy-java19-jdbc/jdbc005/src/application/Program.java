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
        conn.setAutoCommit(false); // estabelece que as mudanças vão ser salvas apenas quando houver um commit
        st = conn.prepareStatement("UPDATE city SET Name = ? WHERE Name = ?");
        st.setString(1, "Elias Fausto");
        st.setString(2, "Salto");
        int rows = st.executeUpdate();

//        int x=1;
//        if (x<2) {
//            throw new DbException("simulando erro!");
//        }

        int rows2 = st.executeUpdate("UPDATE city SET Population = 53433 WHERE Id = 433");

        conn.commit(); // confirma as mudanças e executa a transação por completo

        System.out.println(rows);
        System.out.println(rows2);

        System.out.println("Rows updated: " + rows);
    } catch (SQLException e) {
        try {
            conn.rollback(); // executa um rollback a partir de qualquer erro na transação
        } catch (SQLException e1) {
            throw new DbException(e1.getMessage());
        }
    }

    }
}
