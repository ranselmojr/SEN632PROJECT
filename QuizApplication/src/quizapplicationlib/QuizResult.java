/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationlib;

/**
 *
 * @author romeo
 * 
 * This is to create a multi data type array
 * 
 */
public class QuizResult {

    int resultID;
    int user_id;
    double quizResult;

    QuizResult(int resultID, int user_id, double quizResult) {
        this.resultID = resultID;
        this.user_id = user_id;
        this.quizResult = quizResult;
    }

}
