package hu.transfet.unideb.test.testservice;

import hu.transfet.unideb.application.service.QuestionServiceImpl;
import hu.transfet.unideb.application.model.questions.Question;
import hu.transfet.unideb.application.model.questions.QuestionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionServiceImpl;

    @Test
    public void testFindQuestionShouldSucceedWhenQuestionsListIsNotEmpty(){

        Question testQuestion = new Question();

        List<Question> questions = new ArrayList<>();
        questions.add(testQuestion);

        when(questionRepository.findAll()).thenReturn(questions);

        List<Question> checkQuestions = questionServiceImpl.findAllQuestion();

        verify(questionRepository,timeout(3)).findAll();

        Assert.assertTrue(checkQuestions.size() > 0);
        Assert.assertEquals(testQuestion,checkQuestions.get(0));

    }

    @Test
    public void testFindQuestionByIdShouldSucceedWhenQuestionsIdIsNotNull(){

        Question testQuestion = new Question();
        testQuestion.setId(3);

        when(questionRepository.findById(any(Integer.class))).thenReturn(testQuestion);

        Question checkQuestion = questionServiceImpl.findById(3);

        verify(questionRepository,times(1)).findById(any(Integer.class));

        Assert.assertNotNull(checkQuestion);
        Assert.assertEquals(checkQuestion,testQuestion);

    }

    @Test
    public void testAddQuestionShouldSucceedWhenQuestionIsNotNull(){
        Question testQuestion = new Question();
        testQuestion.setQuestion("Test Question");
        testQuestion.setId(0);

        questionServiceImpl.addQuestion(testQuestion);

        verify(questionRepository,times(1)).save(any(Question.class));
    }

    @Test
    public void testDeleteQuestionShouldSucceedWhenQuestionIsExists(){
        Question testQuestion = new Question();
        testQuestion.setQuestion("Test Question");
        testQuestion.setId(0);

        questionServiceImpl.deleteQuestion(testQuestion);
        verify(questionRepository,times(1)).delete(any(Question.class));
    }
}
