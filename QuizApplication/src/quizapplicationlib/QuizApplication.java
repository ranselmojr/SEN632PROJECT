/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationlib;

import java.util.*;
import quizapplicationui.Login;


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
        
        new Login().setVisible(true);
          
        QuizData data = new QuizData();
        
        //data.writeResult(13, 95.00);
        
        ArrayList<QuizResult> quizResult = data.getResult(13);
        
        Iterator itr=quizResult.iterator();
        
        while(itr.hasNext()){  
            QuizResult qr=(QuizResult)itr.next();  
            System.out.println(qr.resultID+" "+qr.user_id+" "+qr.quizResult);  
        }
        
        
    }
    
}
