package application.database;

import application.model.questions.Question;

import java.util.List;

/**
 *
 * {@link QuestionService}
 * an interface for question service.
 */
public interface QuestionServiceInterface {

    /**
     * add a question to the database.
     * @param question
     */
    void addQuestion(Question question);

    /**
     * delete a question from database.
     * @param question
     */
    void deleteQuestion(Question question);

    /**
     * find all question in database.
     * @return a list which contains all question from database.
     */
    List<Question> findAllQuestion();

    /**
     *
     * @param ID - the question's ID in database.
     * @return a question from database by ID.
     */
    Question findById(int ID);

}
