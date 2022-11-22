
package proyectoseguros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {


    public static Connection getConnection() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_seguromedico", "root", "yli12345");
=======
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_seguromedico", "root", "24demayo");
>>>>>>> 75b708e52d9c509d5b3674bb93c3646ba2840128
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }}



