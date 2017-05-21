package hu.transfet.unideb.application.model.answer;


import hu.transfet.unideb.application.model.questions.Question;

import javax.persistence.*;

@Entity
public class Answer {

    private String answer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Q_ID")
    private Question question;

    public Answer(){

    }

    public Answer(String answer,Question question){
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setQuestion(Question question) {

        this.question = question;
    }

    public Question getQuestion() {

        return question;
    }


    @Override
    public String toString() {
        return "Answer Id:" + getId() + " Answer: " + getAnswer() + " Question :" + getQuestion();
    }
}
