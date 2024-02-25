package model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionSQL {
    public static Connection getConnection() throws SQLException{

        String host = "localhost";
        String user = "admin";
        String password = "admin";
        String database = "atenea";
        boolean ssl = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Librería no encontrada");
        }


        String url = String.format("jdbc:mysql://%s/%s?useSSL=%b", host, database, ssl);
        return DriverManager.getConnection(url, user, password);
    }
}
