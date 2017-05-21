package hu.transfet.unideb.application;

import java.util.List;

public class QuestionParser {

    public String question;
    public int correct;
    public List<String> answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public List<String> getAnswers() {
        return answer;
    }

    public void setAnswers(List<String> answers) {
        this.answer = answers;
    }

    @Override
    public String toString() {
        return "QuestionParser{" +
                "question='" + question + '\'' +
                ", correct=" + correct +
                ", answers=" + answer +
                '}';
    }
}
