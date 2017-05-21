package hu.transfet.unideb.application.model.answer;


import hu.transfet.unideb.application.model.questions.Question;
import javax.persistence.*;

/**
 * Valaszt megvalosito osztaly,mely egy {@link Question} ad valaszt
 *
 * @author Transfet
 */

@Entity
public class Answer {

    private String answer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Q_ID")
    private Question question;

    /**
     * Alapertelmezett konstruktor
     */
    public Answer(){

    }

    /**
     * paramterezett konstruktor
     * @param answer Egy valasz
     * @param question Egy kerdes
     */
    public Answer(String answer,Question question){
        this.answer = answer;
        this.question = question;
    }


    /**
     * Visszaadja a valaszt
     * @return Egy valasz
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Bealltija a valaszt.
     * @param answer Egy valasz
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Bealltija a valasz ID-jet
     * @param id Egy ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Visszaadja egy valasz ID-jet
     * @return Egy ID
     */
    public int getId() {
        return id;
    }

    /**
     * Bealltija a kerdest.
     * @param question Egy kerdes.
     */
    public void setQuestion(Question question) {

        this.question = question;
    }

    /**
     * Visszaadja a kerdest a valaszra.
     * @return Egy kerdes.
     */
    public Question getQuestion() {

        return question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", id=" + id +
                ", question=" + question +
                '}';
    }
}
