package com.src.quizapplication;

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
    public void addUser(String firstname, String lastname, String email,
            String username, String password) 
    {
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
                return;
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

}
