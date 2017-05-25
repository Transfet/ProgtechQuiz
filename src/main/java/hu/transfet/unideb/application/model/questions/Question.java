package hu.transfet.unideb.application.model.questions;

import hu.transfet.unideb.application.model.answer.Answer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Egy kerdest megvalosito osztaly.
 */
@Entity
public class Question {

    /**
     * A kerdes String tipuskent.
     */
    @Column(name = "QUESTION")
    private String question;

    /**
     * A valaszok {@link Answer} listaja.
     */
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answer> answers;

    /**
     * A kerdes ID-je az adatbazis tablaban.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Q_ID")
    private int id;

    /**
     * A helyes valasz indexe a valaszok listajaban.
     */
    private int correctAnswerIndex = 0;

    /**
     * Beallitja a helyes valasz indexet.
     * @param index Egy int ertek, mely a helyes valasz indexet kepezi.
     */
    public void setCorrectAnswerIndex(int index){
        correctAnswerIndex = index;
    }

    /**
     * Visszaadja a helyes valasz indexet.
     * @return Egy int ertek, mely a helyes valasz indexet tartalmazza.
     */
    public int getCorrectAnswerIndex(){
        return correctAnswerIndex;
    }

    /**
     * Alapertelmezett konstruktor, mellyel letrehozunk egy {@code Question} objektumot.
     */
    public Question() {
        answers = new ArrayList<>();
    }

    /**
     * Visszaadja a valaszok listajat. A visszaadott lista egy defenziv masolat.
     *
     * @return Valaszok listaja.
     */
    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    /**
     * Beallitja a kerdeshez tartozo valaszok listajat.
     * @param answers Egy valaszokat {@link Answer} tartalmazo lista.
     */
    public void setAnswers(List<Answer> answers) {

        this.answers = answers;
    }

    /**
     * Beallitja egy kerdes ID-jet.
     *
     * @param id egy Integer tipusu ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Beallitja a kerdest.
     *
     * @param question Egy String tipusu kerdes.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Visszaadja a kerdes ID-jet.
     *
     * @return Egy int tipusu ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Visszaadja a kerdest.
     *
     * @return Egy String tipusu kerdes.
     */
    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        String result = String.format("Question[id=%d , name ='%s']%n", id, question);
        if (answers != null) {
            for (Answer answer : answers) {
                result += String.format(
                        "Answer[id=%d, answer='%s']%n",
                        answer.getId(), answer.getAnswer()
                );
            }
        }
        return result;
    }
}