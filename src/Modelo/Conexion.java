package Modelo;

import java.sql.*;

public class Conexion {

    public Conexion() {

    }

    public Connection getConexion() {

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/db-gestion?serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {

            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("CONEXION FALLIDA");
        }
        
        return con ;
    }
}
