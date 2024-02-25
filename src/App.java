import java.sql.Connection;

import model.Connection.ConectionSQL;

public class App {

    private static Connection c;
    public static void main(String[] args) throws Exception {

        try {
            c = ConectionSQL.getConnection();
        } catch (Exception e) {
            System.out.println("Librería no encontrada" + e);
        }

        
        
    }

}
