/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplicationlib;

import java.sql.*;

/**
 *
 * @author romeo
 */
public class QuizResult {
    public int resultID;
    public int user_id;
    public double quizResult;
    public String quizType;
    public String quizTaken;
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    QuizResult(int resultID, int user_id, double quizResult,
            String quizType, String quizTaken) {
        this.resultID = resultID;
        this.user_id = user_id;
        this.quizResult = quizResult;
        this.quizType = quizType;
        this.quizTaken = quizTaken;
    }
    
}
