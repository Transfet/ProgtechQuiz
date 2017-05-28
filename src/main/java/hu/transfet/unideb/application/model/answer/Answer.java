package hu.transfet.unideb.application.model.answer;


import hu.transfet.unideb.application.model.questions.Question;
import javax.persistence.*;

/**
 * Választ megvalósitó osztály,mely egy {@link Question}-re  ad valaszt.
 *
 * @author Transfet.
 */

@Entity
public class Answer {

    /**
     * A válasz String tipusként.
     */
    private String answer;

    /**
     * A vélasz ID-je a táblában.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * A válaszhoz tartozó kérdés.
     *
     * @see Question
     */
    @ManyToOne
    @JoinColumn(name = "Q_ID")
    private Question question;

    /**
     * Alapértelmezett konstruktor, mely létrehoz egy üres {@code Answer} objektumot.
     */
    public Answer(){

    }

    /**
     * paraméterezett konstruktor, mely létrehoz egy {@code Answer} objektumot.
     * @param answer Egy valasz.
     * @param question Egy kerdes.
     */
    public Answer(String answer,Question question){
        this.answer = answer;
        this.question = question;
    }


    /**
     * Visszaadja a választ String tipusként.
     * @return Egy String, ami a választ tartalmazza.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Bealltija a választ.
     * @param answer Egy String, ami a választ reprezentálja.
     *
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Beálltija a válasz ID-jet.
     * @param id Egy int típusú ID, ami az adatbázis táblában ID-ját reprezentálja.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Visszaadja egy válasz ID-jét.
     * @return Egy int, ami az ID-t tartalmazza.
     */
    public int getId() {
        return id;
    }

    /**
     * Beálltija a kérdést.
     * @param question Egy String, ami a kérdést reprezentálja.
     */
    public void setQuestion(Question question) {

        this.question = question;
    }

    /**
     * Visszaadja a kérdest a válaszra.
     * @return Egy String, ami a kérdést tartalmazza.
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
