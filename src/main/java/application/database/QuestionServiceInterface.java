package application.database;

import application.model.questions.Question;

import java.util.List;

/**
 * Created by Transfet on 2017. 05. 03..
 */
public interface QuestionServiceInterface {

    void addQuestion(Question question);
    void deleteQuestion(Question question);
    List<Question> findAllQuestion();

}
