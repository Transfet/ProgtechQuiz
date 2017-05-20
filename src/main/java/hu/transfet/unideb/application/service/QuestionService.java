package hu.transfet.unideb.application.service;

import hu.transfet.unideb.application.model.questions.Question;

import java.util.List;

/**
 * Kerdes-hozzaferest megvalosito interfesz, melyet a {@link QuestionServiceImpl} implemental.
 *
 * @see Question
 */
public interface QuestionService {

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
