/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationlib;

import java.util.*;
import quizapplicationui.DisplayLogin;


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
        
        new DisplayLogin().setVisible(true);
       
        /*
        
        
        QuizData quiz = new QuizData();
       
        ArrayList<QuizQuestionBank> quizQuestion = quiz.getQuizQuestions(1);
        
        ArrayList<QuizQuestionBank> quizQuestion2 = quiz.shuffleQuestionsChoices(quizQuestion);
        
        
        quizQuestion2.stream().map((qr2) -> {  
            System.out.println("Question: " + qr2.question+ "\n "
                    + "Correct Answer: " + qr2.corAnswer + "\n "
                            + "Wrong Answer 1: " + qr2.wrongAns1 + "\n "
                                    + "Wrong Answer 2: " + qr2.wrongAns2 + "\n "
                                            + "Wrong Answer 3: " + qr2.wrongAns3 + "\n "
                                                    + "Question is if True or False: "+ qr2.is_tf + "\n "
                                                            + "Answer to True or False: " + qr2.tf_ans + "\n "
                                                                    + "Quiz Level/Type: " + qr2.quizType + "\n\n "
                    
            );
            return qr2;
        }).map((qr2) -> {
            ArrayList<String> testShuffle = new ArrayList<String>();
            testShuffle.add(qr2.corAnswer);
            testShuffle.add(qr2.wrongAns1);
            testShuffle.add(qr2.wrongAns2);
            testShuffle.add(qr2.wrongAns3);
            testShuffle.add(qr2.wrongAns3);
            return testShuffle;            
        }).map((testShuffle) -> {
            System.out.println("Before Shuffle " + testShuffle);
            return testShuffle;
        }).map((testShuffle) -> quiz.shuffleQuestionsChoices(testShuffle)).forEachOrdered((testShuffle) -> {
            System.out.println("After Shuffle " + testShuffle +"\n\n");
        });
        
        
       
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
        
        ArrayList<QuizResultData> quizResult = data.getResult(13);
        
        
        Iterator itr=quizResult.iterator();
        
        while(itr.hasNext()){  
            QuizResultData qr=(QuizResultData)itr.next();  
            System.out.println(qr.resultID+" "+qr.user_id+" "+
                    qr.quizResult+ " "+ qr.quizType + " " +
                    qr.quizTaken
            );  
        }
        
        
          */ 
        
        
    }
    
}
