package application.database;

import application.model.questions.Question;
import application.model.questions.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Egy osztaly mely implementalja {@link QuestionService} interfeszt
 * Ezen osztaly metodusaival tudunk a kerdesekhez hozzaferni,illetve kerdeseket modositani az adatbazisban.</p>
 */

@Service
public class QuestionService implements QuestionServiceInterface {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findById(int ID) {
        return questionRepository.findById(ID);
    }
}
