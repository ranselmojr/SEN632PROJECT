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
        
        //new Login().setVisible(true);
       
        
        
        
        QuizData quiz = new QuizData();
       
        ArrayList<QuizQuestion> quizQuestion = quiz.getQuizQuestions(0);
        
        ArrayList<QuizQuestion> quizQuestion2 = quiz.shuffleQuestionsChoices(quizQuestion);
        
        
        Iterator itr2=quizQuestion2.iterator();
        
        while(itr2.hasNext()){  
            QuizQuestion qr2=(QuizQuestion)itr2.next();  
            System.out.println("Question: " + qr2.question+ "\n "
                    + "Correct Answer: " + qr2.corAnswer + "\n "
                    + "Wrong Answer 1: " + qr2.wrongAns1 + "\n "
                    + "Wrong Answer 2: " + qr2.wrongAns2 + "\n "
                    + "Wrong Answer 3: " + qr2.wrongAns3 + "\n "
                    + "Question is if True or False: "+ qr2.is_tf + "\n "
                    + "Answer to True or False: " + qr2.tf_ans + "\n "
                    + "Quiz Level/Type: " + qr2.quizType + "\n\n "
                 
            ); 
            
            ArrayList<String> testShuffle = new ArrayList<String>();
            
            
            
            testShuffle.add(qr2.corAnswer);
            testShuffle.add(qr2.wrongAns1);
            testShuffle.add(qr2.wrongAns2);
            testShuffle.add(qr2.wrongAns3);
            
            System.out.println("Before Shuffle " + testShuffle);
            testShuffle = quiz.shuffleQuestionsChoices(testShuffle);
            
            System.out.println("After Shuffle " + testShuffle +"\n\n");
            
            
            
            
        }
        
        
       
        User user1 = new User();
        boolean x = false;
        x = user1.upgradeUser(13);
        if(x){
            System.out.println("User level is Maxed");
        }else{
            System.out.println("User Level Upgraded");
        }
        
          
         QuizData data = new QuizData();
        
        //data.writeResult(13, 100.00, 2);
        
        ArrayList<QuizResult> quizResult = data.getResult(13);
        
        
        Iterator itr=quizResult.iterator();
        
        while(itr.hasNext()){  
            QuizResult qr=(QuizResult)itr.next();  
            System.out.println(qr.resultID+" "+qr.user_id+" "+
                    qr.quizResult+ " "+ qr.quizType + " " +
                    qr.quizTaken
            );  
        }
        
        
            
        
        
    }
    
}
