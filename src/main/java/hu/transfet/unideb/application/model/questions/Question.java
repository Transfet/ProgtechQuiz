package hu.transfet.unideb.application.model.questions;

import javax.persistence.*;


/**
 * Egy kerdest megvalosito osztaly
 */
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

    /**
     * Alapertelmezett konstruktor
     */
    public Question(){

    }

    /**
     * Parameterezett konstruktor
     * @param question Egy kerdes
     * @param correctAnswer Helyes valasz
     * @param inCorrectAnswer1 Helytelen valasz
     * @param inCorrectAnswer2 Helytelen valasz
     * @param inCorrectAnswer3 Helytelen valasz
     * @param inCorrectAnswer4 Helytelen valasz
     * @param inCorrectAnswer5 Helytelen valasz
     * @param inCorrectAnswer6 Helytelen valasz
     */
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

    /**
     * Beallitja egy kerdes ID-jet
     * @param id egy Integer tipusu ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Beallitja a kerdest
     * @param question Egy String tipusu kerdes
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Visszaadja a kerdes ID-jet
     * @return Egy int tipusu ID
     */
    public int getId() {
        return id;
    }

    /**
     * Visszaadja a helyes valasz
     * @return Egy valasz
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Visszaad egy helytelen valasz
     * @return Egy valasz
     */
    public String getInCorrectAnswer1() {
        return inCorrectAnswer1;
    }

    /**
     * Visszaad egy helytelen valasz
     * @return Egy valasz
     */
    public String getInCorrectAnswer2() {
        return inCorrectAnswer2;
    }

    /**
     * Visszaad egy helytelen valasz
     * @return Egy valasz
     */
    public String getInCorrectAnswer3() {
        return inCorrectAnswer3;
    }

    /**
     * Visszaad egy helytelen valasz
     * @return Egy valasz
     */
    public String getInCorrectAnswer4() {
        return inCorrectAnswer4;
    }

    /**
     * Visszaad egy helytelen valasz
     * @return Egy valasz
     */
    public String getInCorrectAnswer5() {
        return inCorrectAnswer5;
    }

    /**
     * Visszaad egy helytelen valasz
     * @return Egy valasz
     */
    public String getInCorrectAnswer6() {
        return inCorrectAnswer6;
    }


    /**
     * Visszaadja a kerdest
     * @return Egy String tipusu kerdes
     */
    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n" + "Answer: " + correctAnswer + "\n" + "id: " + Long.toString(id);
    }


}