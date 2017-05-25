package hu.transfet.unideb.application;

import java.util.List;

/**
 * Egy kerdest valosit meg Json sema szerint.
 *
 *
 **/
public class QuestionParser {

    /**
     * Egy kerdes String tipuskent.
     */
    public String question;

    /**
     * A helyes valasz indexe a valaszok listajaban.
     */
    public int correct;

    /**
     * Valaszok lista.
     */
    public List<String> answer;

    /**
     * Visszadja a valaszt String-kent.
     * @return Egy kerdes.
     **/
    public String getQuestion() {
        return question;
    }

    /**
     * Beallitja a kerdest.
     * @param question Egy kerdes.
     **/
    public void setQuestion(String question) {
        this.question = question;
    }


    /**
     * Visszaadja a helyes valasz index-et a listaban.
     * @return Egy index.
     **/
    public int getCorrect() {
        return correct;
    }

    /**
     * Beallitja a helyes valasz index-et a listaban.
     * @param correct Egy index.
     */
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    /**
     * Visszaadja a valaszadasi lehetosegek listajat.
     * @return Egy lista.
     **/
    public List<String> getAnswers() {
        return answer;
    }

    /**
     * Beallitja a valaszadasi lehetosegeket.
     * @param answers Egy Stringeket tartalmazo lista.
     **/
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
