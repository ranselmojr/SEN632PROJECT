package quizapplicationlib;

import java.sql.*;
/**
 *
 * @author romeo
 */
public class DatabaseConnection {
    

    private static Connection con;
   
    
    /**
     * Creates a database connection to the server
     */
    public static Connection getConnection() {
        try {
            Class.forName(HideThisFile.DRIVERNAME);
            try {
                con = DriverManager.getConnection(HideThisFile.URL, 
                        HideThisFile.DBUSER, HideThisFile.DBPASS);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}


