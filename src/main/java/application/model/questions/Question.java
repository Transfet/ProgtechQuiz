package application.model.questions;

import javax.persistence.*;

@Entity
public class Question {

    private String question;
    private String correctAnswer;
    private String inCorrectAnswer1;
    private String inCorrectAnswer2;
    private String inCorrectAnswer3;
    private String inCorrectAnswer4;
    private String inCorrectAnswer5;
    private String inCorrectAnswer6;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Question(){

    }

    public Question(String question, String correctAnswer, String inCorrectAnswer1, String inCorrectAnswer2, String inCorrectAnswer3
                    ,String inCorrectAnswer4, String inCorrectAnswer5, String inCorrectAnswer6){

        this.question = question;
        this.correctAnswer = correctAnswer;
        this.inCorrectAnswer1 = inCorrectAnswer1;
        this.inCorrectAnswer2 = inCorrectAnswer2;
        this.inCorrectAnswer3 = inCorrectAnswer3;
        this.inCorrectAnswer4 = inCorrectAnswer4;
        this.inCorrectAnswer5 = inCorrectAnswer5;
        this.inCorrectAnswer6 = inCorrectAnswer6;

    }

    public void setId(int id) {
        this.id = id;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getInCorrectAnswer1() {
        return inCorrectAnswer1;
    }

    public String getInCorrectAnswer2() {
        return inCorrectAnswer2;
    }

    public String getInCorrectAnswer3() {
        return inCorrectAnswer3;
    }

    public String getInCorrectAnswer4() {
        return inCorrectAnswer4;
    }

    public String getInCorrectAnswer5() {
        return inCorrectAnswer5;
    }

    public String getInCorrectAnswer6() {
        return inCorrectAnswer6;
    }


    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n" + "Answer: " + correctAnswer + "\n" + "id: " + Long.toString(id);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}