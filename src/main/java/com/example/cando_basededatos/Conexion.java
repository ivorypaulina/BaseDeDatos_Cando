package com.example.cando_basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/tienda";

    private static final String USER = "root";

    private static final String PASSWORD = "123456";

    public static Connection getConexion() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    public static void main(String[] args) {

        try {

            Connection con = getConexion();

            System.out.println("Conexion exitosa");

            con.close();

        } catch (Exception e) {

            System.out.println("Error de conexion");

            e.printStackTrace();
        }
    }
}