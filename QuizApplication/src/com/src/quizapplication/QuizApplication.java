/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.src.quizapplication;


/**
 *
 * @author romeo
 */
public class QuizApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean test = false;
        User myUser = new User();
        
        myUser.addUser("Romeo", "Anselmo", "test@test.com", "user1", "pass1");
        
        test = myUser.authenticateUser("user1", "pass1");
        
        if(test)
        {
            System.out.println("Username Authenticated Test!!!");
        }
        else
        {
            System.out.println("Username and/or Password Invalid!!!");
        }
        
        
    }
    
}
