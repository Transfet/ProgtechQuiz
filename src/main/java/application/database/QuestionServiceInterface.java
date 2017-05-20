package application.database;

import application.model.questions.Question;

import java.util.List;

/**
 * Kerdes-hozzaferest megvalosito interfesz, melyet a {@link QuestionService} implemental.
 *
 * @see Question
 */
public interface QuestionServiceInterface {

    /**
     * Hozzaad egy kerdest az adatbazishoz
     * @param question Egy kerdes
     */
    void addQuestion(Question question);

    /**
     * Torol egy kerdest az adatbazisbol
     * @param question Egy kerdes
     */
    void deleteQuestion(Question question);

    /**
     * Listazza az adatbazisban szereplo osszes kerdest.
     * @return Egy kerdesekbol allo lista
     */
    List<Question> findAllQuestion();

    /**
     *  ID alapjan megkeres egy kerdest.
     *
     * @param ID A kerdes ID-je
     * @return Egy kerdes
     */
    Question findById(int ID);

}
