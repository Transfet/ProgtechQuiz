package application.model.questions;

import javax.persistence.*;

/**
 * Created by Transfet on 2017. 04. 29..
 */

@Entity
public class Question {

    private String question;
    private String answer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Question(String question, String answer) {

        this.answer = answer;
        this.question = question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n" + "Answer: " + answer + "\n" + "id: " + Long.toString(id);
    }
}