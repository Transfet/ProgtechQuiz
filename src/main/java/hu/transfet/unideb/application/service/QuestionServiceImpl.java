package hu.transfet.unideb.application.service;

import hu.transfet.unideb.application.model.questions.Question;
import hu.transfet.unideb.application.model.questions.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Egy osztaly mely implementalja {@link QuestionServiceImpl} interfeszt
 * Ezen osztaly metodusaival tudunk a kerdesekhez hozzaferni,illetve kerdeseket modositani az adatbazisban.</p>
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    /**
     *A service {@link QuestionRepository}-ja.
     */
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
