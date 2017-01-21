/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationlib;

/**
 *
 * @author romeo
 */
public class QuizQuestion {
    String question;
    String corAnswer;
    String wrongAns1;
    String wrongAns2;
    String wrongAns3;
    boolean is_tf;
    boolean tf_ans;
    int quizType;
    

    QuizQuestion(String question, String corAnswer, String wrongAns1, 
            String wrongAns2, String wrongAns3, boolean is_tf, 
            boolean tf_ans, int quizType) 
    {
        this.question = question;
        this.corAnswer = corAnswer;
        this.wrongAns1 = wrongAns1;
        this.wrongAns2 = wrongAns2;
        this.wrongAns3 = wrongAns3;
        this.is_tf = is_tf;
        this.tf_ans = tf_ans;
        this.quizType = quizType ;
    }
    
}
