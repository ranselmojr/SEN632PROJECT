package quizapplicationlib;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

/**
 *
 * @author romeo
 */
public class User {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /**
     * Register a User
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param username
     * @param password
     *
     */
    public boolean addUser(String firstname, String lastname, String email,
            String username, String password) {
        String value = null;
        String sql = "insert into user (firstname, lastname, "
                + "email, username, password)"
                + "values (?,?,?,?,?)";
        try {
            con = DatabaseConnection.getConnection();

            String sql1 = "select * from user where username = '"
                    + username + " ' ";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                value = rs.getString(5);
            }

            if (username.equals(value)) {
                System.out.println("Username already exist!!!");
                con.close();
                return false;
            } else {
                PreparedStatement preparedStmt = con.prepareStatement(sql);

                preparedStmt.setString(1, firstname);
                preparedStmt.setString(2, lastname);
                preparedStmt.setString(3, email);
                preparedStmt.setString(4, username);
                preparedStmt.setString(5, password);

                preparedStmt.execute();
                System.out.println("Username Registered!!!");
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return true;

    }

    /**
     * Authenticate a User
     *
     * @param username
     * @param password
     *
     * @return boolean
     */
    public boolean authenticateUser(String username, String password) {
        String value_user = null;
        String value_pass = null;

        try {
            con = DatabaseConnection.getConnection();
            //stmt = con.createStatement();
            //rs = stmt.executeQuery(sql);

            String sql = "select * from user where username = '" + username
                    + "' AND password = '" + password + "'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                value_user = rs.getString(5);
                value_pass = rs.getString(6);
            }

            if (username.equals(value_user) && password.equals(value_pass)) {
                //System.out.println("Username Authenticated!!!");

                con.close();
                return true;
            } //else {
            //    System.out.println("Username does not exist!!!");
            //}
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    /**
     * Get the user info from the Database and return data 
     *    in an Object
     * 
     * @param username
     * @return 
     */
    public Object[] getUser(String username) {
        String value_user = null;
        Object[] userData = new Object[7];

        try {
            con = DatabaseConnection.getConnection();
            //stmt = con.createStatement();
            //rs = stmt.executeQuery(sql);

            String sql = "select * from user where username = '"
                    + username + "'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                userData[0] = rs.getInt(1);
                userData[1] = rs.getString(2);
                userData[2] = rs.getString(3);
                userData[3] = rs.getString(4);
                userData[4] = rs.getString(5);
                userData[5] = rs.getString(7);
                userData[6] = rs.getInt(8);

            }
            
            System.out.println();

            con.close();
            return userData;

        } catch (Exception e) {
            System.out.println(e);
        }
        return userData;
    }
    
    /**
     * Get the user info from the Database and return data 
     *    in an Object
     * 
     * @param username
     * @return 
     */
    public void updateUser(Object[] user) {
        String value_user = null;
        Object[] userData = new Object[7];

        try {
            con = DatabaseConnection.getConnection();
            //stmt = con.createStatement();
            //rs = stmt.executeQuery(sql);

            String sql2 = "update user set"
                    + " firstname='"+ user[1] +"',"
                    + " lastname='" + user[2] +"',"
                    + " email='" + user[3] +"',"
                    + " quizlevel='" + Integer.parseInt((String)user[4])+"',"
                    + " is_admin=" + user[5]
                    +" where id="+user[0];
            PreparedStatement preparedStmt = con.prepareStatement(sql2);
            preparedStmt.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean upgradeUser(int userID){
        
        int userLevel = 0;
        
        try {
            con = DatabaseConnection.getConnection();
            
            String sql = "select quizlevel from user where id = '"
                    + userID + "'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            
            
            if(rs.first()){
                userLevel = rs.getInt(1);
            }
            
            if(userLevel != 4){
                
    
                userLevel += 1;
                String sql2 = "update user set quizlevel="
                        +userLevel + " where id="+ userID;
                
                PreparedStatement preparedStmt = con.prepareStatement(sql2);
                
              

                preparedStmt.executeUpdate();
                con.close();
                return false;
                
        
            }
            
            con.close();
            
            

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return true;
    }

}